package Service;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.StatisticsResponse;

import dao.OrderDao;
import dto.Orders;

@Service
public class StatisticService {
	 private OrderDao orderDao;

	 public StatisticService(OrderDao orderDao) {
		 this.orderDao = orderDao;
	 }
	 
	 public StatisticsResponse monthlyOrderStatistics() { //월별집계
		 	YearMonth currentMonth = YearMonth.now();
	        YearMonth previousMonth = currentMonth.minusMonths(1);

	        List<Orders> orders = orderDao.selectByOrderDateTime(previousMonth.atDay(1).atStartOfDay(), currentMonth.atEndOfMonth().atTime(23, 59, 59));

	        int totalNumber = orders.size();
	        long totalPrice = calculateTotalPrice(orders);

	        StatisticsResponse response = new StatisticsResponse(previousMonth.atDay(1).atStartOfDay(), totalNumber, totalPrice);
	        return response;
	    }

	    public StatisticsResponse weeklyOrderStatistics() {//주간집계
	        LocalDate currentDate = LocalDate.now();
	        LocalDate previousWeekStart = currentDate.minusWeeks(1).with(java.time.DayOfWeek.MONDAY);
	        LocalDate previousWeekEnd = currentDate.minusWeeks(1).with(java.time.DayOfWeek.SUNDAY);

	        List<Orders> orders = orderDao.selectByOrderDateTime(previousWeekStart.atStartOfDay(), previousWeekEnd.atTime(23, 59, 59));

	        int totalNumber = orders.size();
	        long totalPrice = calculateTotalPrice(orders);

	        StatisticsResponse response = new StatisticsResponse(previousWeekStart.atStartOfDay(), totalNumber, totalPrice);
	        return response;
	    }

	    public StatisticsResponse dailyOrderStatistics() {//일별집계
	        LocalDateTime currentDateTime = LocalDateTime.now();
	        LocalDateTime previousDayStart = currentDateTime.minusDays(1).withHour(0).withMinute(0).withSecond(0);
	        LocalDateTime previousDayEnd = currentDateTime.minusDays(1).withHour(23).withMinute(59).withSecond(59);

	        List<Orders> orders = orderDao.selectByOrderDateTime(previousDayStart, previousDayEnd);

	        int totalNumber = orders.size();
	        long totalPrice = calculateTotalPrice(orders);

	        StatisticsResponse response = new StatisticsResponse(previousDayStart, totalNumber, totalPrice);
	        return response;
	    }

	    private long calculateTotalPrice(List<Orders> orders) {
	        long totalPrice = 0;
	        for (Orders order : orders) {
	            totalPrice += order.getTotalPrice();
	        }
	        return totalPrice;
	    }
}
