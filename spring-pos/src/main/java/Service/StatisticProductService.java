package Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.StatisticsProductResponse;

import dao.OrderDao;
import dao.OrderedProductDao;
import dao.ProductDao;
import dto.OrderedProduct;
import dto.Orders;
import dto.Product;

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

	    List<Orders> orders = orderDao.selectAllOrders();
	    Map<Integer, Integer> productCountMap = new HashMap<>();

	    // Count the total quantity for each product
	    for (Orders order : orders) {
	        List<OrderedProduct> orderedProducts = orderedProductDao.selectByOrderId(order.getOrderId());
	        for (OrderedProduct orderedProduct : orderedProducts) {
	            int productId = orderedProduct.getProductId();
	            int count = orderedProduct.getCount();
	            productCountMap.put(productId, productCountMap.getOrDefault(productId, 0) + count);
	        }
	    }

	    // Create StatisticsProductResponse objects for each product
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

	    // Sort the rankings based on the total quantity in descending order
	    rankings.sort(Comparator.comparingInt(StatisticsProductResponse::getCount).reversed());

	    return rankings;
	}
}
