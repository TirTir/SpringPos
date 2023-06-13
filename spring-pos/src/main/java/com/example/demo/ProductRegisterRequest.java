package com.example.demo;

import java.time.LocalDateTime;

public class ProductRegisterRequest {
	private String productName; //상품명
	private long price; //가격
	private int totalCount; //재고
	private LocalDateTime storeDateTime; //입고 날짜
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public LocalDateTime getStoreDateTime() {
		return storeDateTime;
	}
	public void setStoreDateTime(LocalDateTime storeDateTime) {
		this.storeDateTime = storeDateTime;
	}
}
