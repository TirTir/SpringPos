package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import Service.OrderService;
import dto.OrderedProduct;

public class OrderedProductDao {
	private JdbcTemplate jdbcTemplate;
	private OrderService orderService;
	
	public OrderedProductDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public long insert(final OrderedProduct orderedProduct) { //주문 상세 정보 추가
		KeyHolder keyHolder= new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) 
						throws SQLException{
						PreparedStatement pstmt= con.prepareStatement(
								"insert into ORDEREDPRODUCT (number, orderId, productId, count, price) values (?, ?, ?, ?, ?)",
								new String[] {"ID"});
						pstmt.setInt(1, orderedProduct.getOrderId());
						pstmt.setInt(2, orderedProduct.getProductId());
						pstmt.setInt(3, orderedProduct.getCount());
						pstmt.setLong(4, orderedProduct.getPrice());
						return pstmt;
						}
					}, keyHolder);
		Number keyValue= keyHolder.getKey();
		orderedProduct.setNumber(keyValue.intValue());
		
		return orderService.calculateTotalPrice(orderedProduct.getOrderId()); //합계 반환
	}
	
	public List<OrderedProduct> selectByOrderId(int orderId) { //주문 상세 정보 조회
		String sql = "SELECT * FROM OrderedProduct WHERE orderId = ?";
	    List<OrderedProduct> result = jdbcTemplate.query(sql, (rs, rowNum) -> mapProduct(rs), orderId);
	    
	    return result.isEmpty() ? null : result;
	}
	
	public OrderedProduct selectByProductId(int orderId, int productId) { //주문 상세 정보 조회
		String sql = "SELECT * FROM OrderedProduct WHERE orderId = ? AND productId = ?";
	    List<OrderedProduct> result = jdbcTemplate.query(sql, (rs, rowNum) -> mapProduct(rs), orderId, productId);
	    
	    return result.isEmpty() ? null : result.get(0);
	}
	
	public OrderedProduct selectByNumber(int number) { //주문 상세 정보 조회
		String sql = "SELECT * FROM OrderedProduct WHERE number = ?";
	    List<OrderedProduct> result = jdbcTemplate.query(sql, (rs, rowNum) -> mapProduct(rs), number);
	    
	    return result.isEmpty() ? null : result.get(0);
	}
	
	public void deleteOrderedProduct(int number) {
	    String sql = "DELETE FROM PRODUCT WHERE number = ?";
	    
	    jdbcTemplate.update(sql, number);
	}
	
	private OrderedProduct mapProduct(ResultSet rs) throws SQLException {
		int number = rs.getInt("number");
	    int orderId = rs.getInt("orderId");
	    int productId = rs.getInt("productId");
	    int count = rs.getInt("count");
	    long price = rs.getLong("price");

	    OrderedProduct product = new OrderedProduct(orderId, productId, count, price);
	    product.setNumber(number);
	    return product;
	}
}
