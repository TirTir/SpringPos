package com.example.demo.dto;

public class OrderedProduct {
	private int number;
	private int orderId; //주문 번호
	private int productId; //상품 코드
	private int count; //수량
	private long price; //가격
	
	public OrderedProduct(int orderId, int productId, int count, long price) {
		this.orderId = orderId;
		this.productId = productId;
		this.count = count;
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
}
