package com.example.demo.service;

import java.util.ArrayList;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.StatisticsResponse;
import com.example.demo.dao.OrderDao;
import com.example.demo.dto.Orders;

@Service
public class StatisticPeriodService {
	 private OrderDao orderDao;

	 public StatisticPeriodService(OrderDao orderDao) {
		 this.orderDao = orderDao;
	 }
	 
	 public List<StatisticsResponse> getMonthlyOrderStatistics() { //월별집계
		 YearMonth currentMonth = YearMonth.now();
	     YearMonth previousMonth = YearMonth.of(currentMonth.getYear(), Month.JANUARY); // 해당 년도의 첫째 달

	     List<StatisticsResponse> statisticsList = new ArrayList<>();

		while (previousMonth.isBefore(currentMonth)) {
			LocalDateTime monthStart = previousMonth.atDay(1).atStartOfDay();
			LocalDateTime monthEnd = previousMonth.atEndOfMonth().atTime(23, 59, 59);
		
			 List<Orders> orders = orderDao.selectByOrderDateTime(monthStart, monthEnd);
			 
			 int totalNumber = orders.size();
			 long totalPrice = calculateTotalPrice(orders);
		
			 StatisticsResponse response = new StatisticsResponse(monthStart, totalNumber, totalPrice);
			 statisticsList.add(response);
		
			 previousMonth = previousMonth.plusMonths(1);
		}

	    return statisticsList;
	 }

	 public List<StatisticsResponse> getWeeklyOrderStatistics() {//주간집계
	    List<StatisticsResponse> statisticsList = new ArrayList<>();

	    LocalDate currentDate = LocalDate.now();
	    LocalDate previousWeekStart = currentDate.minusWeeks(1).with(java.time.DayOfWeek.MONDAY);
	    LocalDate previousWeekEnd = currentDate.minusWeeks(1).with(java.time.DayOfWeek.SUNDAY);

	    while (previousWeekStart.isBefore(currentDate)) {
	        LocalDateTime weekStart = previousWeekStart.atStartOfDay();
	        LocalDateTime weekEnd = previousWeekEnd.atTime(23, 59, 59);

	        List<Orders> orders = orderDao.selectByOrderDateTime(weekStart, weekEnd);

	        int totalNumber = orders.size();
	        long totalPrice = calculateTotalPrice(orders);

	        StatisticsResponse response = new StatisticsResponse(weekStart, totalNumber, totalPrice);
	        statisticsList.add(response);

	        previousWeekStart = previousWeekStart.plusWeeks(1);
	        previousWeekEnd = previousWeekEnd.plusWeeks(1);
	    }

	    return statisticsList;
	 }

	 public List<StatisticsResponse> getDailyOrderStatistics() {
		    List<StatisticsResponse> statisticsList = new ArrayList<>();

		    LocalDateTime currentDateTime = LocalDateTime.now();
		    LocalDateTime previousDayStart = currentDateTime.minusDays(1).withHour(0).withMinute(0).withSecond(0);
		    LocalDateTime previousDayEnd = currentDateTime.minusDays(1).withHour(23).withMinute(59).withSecond(59);

		    while (previousDayStart.isBefore(currentDateTime)) {
		        List<Orders> orders = orderDao.selectByOrderDateTime(previousDayStart, previousDayEnd);

		        int totalNumber = orders.size();
		        long totalPrice = calculateTotalPrice(orders);

		        StatisticsResponse response = new StatisticsResponse(previousDayStart, totalNumber, totalPrice);
		        statisticsList.add(response);

		        previousDayStart = previousDayStart.plusDays(1);
		        previousDayEnd = previousDayEnd.plusDays(1);
		    }

		    return statisticsList;
		}
	 
	    private long calculateTotalPrice(List<Orders> orders) {
	        long totalPrice = 0;
	        for (Orders order : orders) {
	            totalPrice += order.getTotalPrice();
	        }
	        return totalPrice;
	    }
}
