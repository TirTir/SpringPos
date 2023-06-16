package com.example.demo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Service.InventoryService;
import Service.OrderService;
import Service.OrderedProductService;
import Service.ProductService;
import Service.StatisticProductService;
import Service.StatisticService;
import Service.UserAuthService;
import dao.MemberDao;
import dao.OrderDao;
import dao.OrderedProductDao;
import dao.ProductDao;

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
    public UserAuthService userAuthService() { 
		 return new UserAuthService(memberDao());
	}
	
	@Bean
	public ProductDao productDao() {
		return new ProductDao(dataSource());
	}
	
	@Bean
    public ProductService productService() { 
		 return new ProductService(productDao());
	}
	
	@Bean
	public OrderDao orderDao() {
		return new OrderDao(dataSource());
	}
	
	@Bean
    public OrderService orderService() { 
		 return new OrderService(productDao(), orderDao(), orderedProductDao());
	}
	
	@Bean
	public OrderedProductDao orderedProductDao() {
		return new OrderedProductDao(dataSource());
	}
	
	@Bean
    public OrderedProductService orderedProductService() { 
		 return new OrderedProductService(productDao(), orderDao(), orderedProductDao());
	}

	@Bean
	public StatisticService statisticService() {
		return new StatisticService(orderDao());
	}
	
	@Bean
    public StatisticProductService statisticProductService() { 
		 return new StatisticProductService(orderDao(), productDao(), orderedProductDao());
	}
	
	@Bean
    public InventoryService inventoryService() { 
		 return new InventoryService(productDao());
	}
}