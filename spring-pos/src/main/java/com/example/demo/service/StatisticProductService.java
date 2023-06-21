package com.example.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.StatisticsProductResponse;

import com.example.demo.dao.OrderDao;
import com.example.demo.dao.OrderedProductDao;
import com.example.demo.dao.ProductDao;
import com.example.demo.dto.OrderedProduct;
import com.example.demo.dto.Orders;
import com.example.demo.dto.Product;

@Service
public class StatisticProductService {
	private OrderDao orderDao;
	private ProductDao productDao;
	private OrderedProductDao orderedProductDao;
	
	public StatisticProductService(OrderDao orderDao, ProductDao productDao, OrderedProductDao orderedProductDao) {
		this.orderDao = orderDao;
		this.productDao = productDao;
		this.orderedProductDao = orderedProductDao;
	}

	public List<StatisticsProductResponse> getProductRankings() {
		List<StatisticsProductResponse> rankings = new ArrayList<>();
	    Map<Integer, Integer> productCountMap = new HashMap<>();

	    List<Orders> orders = orderDao.selectAllOrders();
	    
	    for (Orders order : orders) {
	        List<OrderedProduct> orderedProducts = orderedProductDao.selectByOrderId(order.getOrderId());
	        for (OrderedProduct orderedProduct : orderedProducts) {
	            int productId = orderedProduct.getProductId();
	            int count = orderedProduct.getCount();
	            productCountMap.put(productId, productCountMap.getOrDefault(productId, 0) + count);
	        }
	    }

	    for (Map.Entry<Integer, Integer> entry : productCountMap.entrySet()) {
	        int productId = entry.getKey();
	        int count = entry.getValue();

			Product product = productDao.selectByProductId(productId);

	        if (product != null) {
	            String productName = product.getProductName();
	            long price = product.getPrice();
	            long totalPrice = price * count;

	            StatisticsProductResponse response = new StatisticsProductResponse(productId, productName, price, count, totalPrice);
	            rankings.add(response);
	        }
	    }

	    rankings.sort(Comparator.comparingInt(StatisticsProductResponse::getCount).reversed());

	    return rankings;
	}
}
