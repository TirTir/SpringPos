package com.example.demo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dao.MemberDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.OrderedProductDao;
import com.example.demo.dao.ProductDao;

@Configuration //Spring 설정 클래스
public class JavaConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() { //데이터베이스 연결에 필요한 DataSource 객체를 생성하여 bean으로 등록
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/spring_pos?characterEncoding=utf8&serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("0000abc");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
	
	@Bean
	public ProductDao productDao() {
		return new ProductDao(dataSource());
	}
	
	@Bean
	public OrderDao orderDao() {
		return new OrderDao(dataSource());
	}
	
	@Bean
	public OrderedProductDao orderedProductDao() {
		return new OrderedProductDao(dataSource());
	}
}