package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.ProductRegisterRequest;
import com.example.demo.dao.ProductDao;
import com.example.demo.dto.Product;

@Service
public class ProductService {
	private ProductDao productDao;
	
	public ProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void regist(ProductRegisterRequest req) throws Exception { //상품 등록
		Product product = productDao.selectByProductName(req.getProductName());
		if (product != null) { //동일 상품 존재 여부
			throw new Exception("동일한 상품이 있습니다.");
		}
		Product newProduct = new Product(req.getProductName(), req.getPrice(), req.getTotalCount(),
				LocalDateTime.now());
		productDao.insert(newProduct);
	}
	
	public Product search(String search) throws Exception {
		Product product = productDao.selectByProductName(search);
		if (product == null) {
			throw new Exception("존재하지 않는 상품입니다.");
		}
		return product;
	}
}
