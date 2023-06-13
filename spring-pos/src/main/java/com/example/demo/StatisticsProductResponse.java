package com.example.demo;

public class StatisticsProductResponse {
	private int productId;
	private String productName;
	private long price;
	private int count; 
	private long totalPrice;
	
	
	public StatisticsProductResponse(int productId, String productName, long price, int count, long totalPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.count = count;
		this.totalPrice = totalPrice;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
}
