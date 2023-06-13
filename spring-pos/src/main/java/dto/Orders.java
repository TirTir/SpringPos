package dto;

import java.time.LocalDateTime;

public class Orders {
	private int orderId; //주문 번호
	private LocalDateTime orderDateTime; //주문 날짜 및 시간
	private long totalPrice; //합계
	
	public Orders(LocalDateTime orderDateTime, long totalPrice)
	{
		this.orderDateTime = orderDateTime;
		this.totalPrice = totalPrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
}
