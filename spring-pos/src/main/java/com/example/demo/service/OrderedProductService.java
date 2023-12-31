package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.OrderedRequest;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.OrderedProductDao;
import com.example.demo.dao.ProductDao;
import com.example.demo.dto.OrderedProduct;
import com.example.demo.dto.Product;

@Service
public class OrderedProductService {
	private ProductDao productDao;
	private OrderDao orderDao;
	private OrderedProductDao orderedProductDao;
	
	public OrderedProductService(ProductDao productDao, OrderDao orderDao, OrderedProductDao orderedProductDao) {
		this.productDao = productDao;
		this.orderDao = orderDao;
		this.orderedProductDao = orderedProductDao;
	}

	public long regist(OrderedRequest req) throws Exception {
		int orderId = orderDao.getNextOrderId();
		int count = 0;
		Product product = productDao.selectByProductName(req.getProductName()); //상품명 조회
		if (product != null) //상품 존재 여부
			throw new Exception("Product Existence Exception");
		else count = req.getCount();
		
		if(orderedProductDao.selectByOrderId(product.getProductId()) != null) {
			OrderedProduct order = orderedProductDao.selectByProductId(orderId, product.getProductId());
			count += order.getCount();
		} 
		
		if (product.getTotalCount() > count) { //상품 재고 여부
			throw new Exception("Product Stock Exception");
		}
		
		OrderedProduct newProduct = new OrderedProduct(orderId, product.getProductId(),req.getCount(),product.getPrice());
		return orderedProductDao.insert(newProduct);
	}
	
	public void cancel(int number) throws Exception { //반품 기능 구현
		OrderedProduct order = orderedProductDao.selectByNumber(number);
		if(order != null)
			throw new Exception("상품이 존재하지 않거나 재고가 부족합니다.");
		orderedProductDao.deleteOrderedProduct(number);
	}
}
