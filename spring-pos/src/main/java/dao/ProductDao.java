package dao;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.sql.DataSource;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import dto.Product;

public class ProductDao {
	private JdbcTemplate jdbcTemplate;
	
	public ProductDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(final Product product) { //상품 정보 추가
		KeyHolder keyHolder= new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) 
						throws SQLException{
						PreparedStatement pstmt= con.prepareStatement(
								"insert into PRODUCT (productId, productName, price, totalCount, storeDateTime) values (?, ?, ?, ?, ?)",
								new String[] {"ID"});
						pstmt.setString(1,  product.getProductName());
						pstmt.setLong(2,  product.getPrice());
						pstmt.setInt(3,  product.getTotalCount());
						pstmt.setTimestamp(4, Timestamp.valueOf(product.getStoreDateTime()));
						return pstmt;
						}
					}, keyHolder);
		Number keyValue= keyHolder.getKey();
		product.setProductId(keyValue.intValue());
	}
	
	public List<Product> selectAllProduct() { //상품 전체 조회
		 String sql = "SELECT * FROM PRODUCT";
		    
		 List<Product> result = jdbcTemplate.query(sql, (rs, rowNum) -> mapProduct(rs));
		    
		 return result.isEmpty() ? null : result;
	}
	
	public Product selectByProductId(int productId) { //상품 아이디 조회
		 String sql = "SELECT * FROM PRODUCT WHERE productId = ?";
		    
		 List<Product> result = jdbcTemplate.query(sql, (rs, rowNum) -> mapProduct(rs), productId);
		    
		 return result.isEmpty() ? null : result.get(0);
	}
	
	public Product selectByProductName(String productName) { //상품명 조회
		String sql = "SELECT * FROM PRODUCT WHERE productName = ?";
	    
	    List<Product> result = jdbcTemplate.query(sql, (rs, rowNum) -> mapProduct(rs), productName);
	    
	    return result.isEmpty() ? null : result.get(0);
	}
	
	public void updateProductQuantity(int productId, int totalCount) {
	    String sql = "UPDATE PRODUCT SET totalCount = ? WHERE productId = ?";
	    
	    jdbcTemplate.update(sql, totalCount, productId);
	}
	
	public void deleteProduct(int productId) {
		String sql = "DELETE FROM PRODUCT WHERE productId = ?";
	    
		jdbcTemplate.update(sql, productId);
	}
	
	private Product mapProduct(ResultSet rs) throws SQLException {
	    int productId = rs.getInt("productId");
	    String productName = rs.getString("productName");
	    long price = rs.getLong("price");
	    int totalCount = rs.getInt("totalCount");
	    LocalDateTime storeDateTime = rs.getTimestamp("storeDateTime").toLocalDateTime();

	    Product product = new Product(productName, price, totalCount, storeDateTime);
	    product.setProductId(productId);
	    return product;
	}
}