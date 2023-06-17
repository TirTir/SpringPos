package Service;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import dao.OrderDao;
import dao.OrderedProductDao;
import dao.ProductDao;
import dto.OrderedProduct;
import dto.Orders;

@Service
public class OrderService { 
	private ProductDao productDao;
    private OrderDao orderDao;
    private OrderedProductDao orderedProductDao;
	private OrderService orderService;
	
	public OrderService(ProductDao productDao, OrderDao orderDao, OrderedProductDao orderedProductDao) {
        this.productDao = productDao;
        this.orderDao = orderDao;
        this.orderedProductDao = orderedProductDao;
    }
	
	public void regist() throws Exception {
		int orderId = orderDao.getNextOrderId(); //주문 번호
		LocalDateTime orderDateTime = LocalDateTime.now(); // 구매 시간
		
		List<OrderedProduct> order = orderedProductDao.selectByOrderId(orderId); //주문 상세 정보 조회
		if (order != null) //주문 정보 존재 여부
			throw new Exception("Order Existence Exception");
		
		Orders newOrder = new Orders(orderDateTime, orderService.calculateTotalPrice(orderId));
		orderDao.insert(newOrder); 
		update(orderId);
	}
	
	public long calculateTotalPrice(int orderId){ //합계 계산
		List<OrderedProduct> result = orderedProductDao.selectByOrderId(orderId);

		long totalPrice = 0;
	    for (OrderedProduct orderedProduct : result) {
	    	int productCount = orderedProduct.getCount();
	        long productPrice = orderedProduct.getPrice();
	        totalPrice += productCount * productPrice;
	    }
	    return totalPrice;
	}
	
	public void update(int orderId) {
		List<OrderedProduct> order = orderedProductDao.selectByOrderId(orderId); //주문 상세 정보 조회

		for (OrderedProduct orderedProduct : order) {
	    	int productId = orderedProduct.getProductId();
	    	int totalCount = orderedProduct.getCount();
	        productDao.updateProductQuantity(productId, totalCount);
	    }
	}
	
	public List<Orders> orderHistory(){ //판매 내역
		LocalDate currentDateTime = LocalDate.now().minusDays(1);
		LocalDateTime previousDayStart = currentDateTime.atStartOfDay();
		LocalDateTime previousDayEnd = currentDateTime.atTime(23, 59, 59);

        List<Orders> orders = orderDao.selectByOrderDateTime(previousDayStart, previousDayEnd);
		
		return orders;
	}
}
