package com.example.demo;

import java.time.LocalDateTime;

public class StatisticsResponse { //매출 현황
	private LocalDateTime orderDateTime;
	private int totalNumber;
	private long tatalPrice;
	
	public StatisticsResponse(LocalDateTime orderDateTime, int totalNumber, long totalPrice) {
        this.orderDateTime = orderDateTime;
        this.totalNumber = totalNumber;
        this.tatalPrice = totalPrice;
    }
	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}
	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public long getTatalPrice() {
		return tatalPrice;
	}
	public void setTatalPrice(long tatalPrice) {
		this.tatalPrice = tatalPrice;
	}
}
