package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import dto.Orders;

public class OrderDao {
	private JdbcTemplate jdbcTemplate;
	
	public OrderDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(final Orders order) { //구매 정보 추가
		KeyHolder keyHolder= new GeneratedKeyHolder();
		
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) 
						throws SQLException{
						PreparedStatement pstmt= con.prepareStatement(
								"insert into ORDERS (orderId, orderDateTime, totalPrice) values (?, ?, ?)",
								new String[] {"orderID"});
						pstmt.setTimestamp(1, Timestamp.valueOf(order.getOrderDateTime()));
						pstmt.setLong(2, order.getTotalPrice());
						return pstmt;
						}
					}, keyHolder);
		Number keyValue= keyHolder.getKey();
		order.setOrderId(keyValue.intValue());
	}
	
	public int getNextOrderId() { //마지막 orderId를 확인하고 그 값보다 1 큰 값을 반환
	    int maxOrderId = jdbcTemplate.queryForObject("SELECT MAX(orderId) FROM ORDERS", Integer.class);
	    return maxOrderId + 1;
	}
	
	public Orders selectByOrderId(int orderId) { //주문 번호 조회
		String sql = "select * from Orders where OrderId = ?";
		List<Orders> result = jdbcTemplate.query(sql, (rs, rowNum) -> mapOrder(rs), orderId);

		return result.isEmpty() ? null : result.get(0);
	}
	
	public List<Orders> selectAllOrders() { //주문 전체 조회
		String sql = "select * from Orders";
		List<Orders> result = jdbcTemplate.query(sql, (rs, rowNum) -> mapOrder(rs));

		return result;
	}

	public List<Orders> selectByOrderDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime){
		String sql = "SELECT * FROM Orders WHERE orderDateTime >= ? AND orderDateTime <= ?";
	    Timestamp startTimestamp = Timestamp.valueOf(startDateTime);
	    Timestamp endTimestamp = Timestamp.valueOf(endDateTime);

	    List<Orders> result = jdbcTemplate.query(sql, (rs, rowNum) -> mapOrder(rs), startTimestamp, endTimestamp);

	    return result;
	}
	private Orders mapOrder(ResultSet rs) throws SQLException {
	    int orderId = rs.getInt("orderId");
	    LocalDateTime orderDateTime = rs.getTimestamp("orderDateTime").toLocalDateTime();
	    long totalPrice = rs.getLong("totalPrice");

	    Orders order = new Orders(orderDateTime, totalPrice);
	    order.setOrderId(orderId);
	    return order;
	}
	
}
