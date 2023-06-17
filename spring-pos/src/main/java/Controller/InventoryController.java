package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Service.InventoryService;
import Service.OrderService;
import dao.OrderDao;
import dao.ProductDao;
import dto.Orders;
import dto.Product;

@Controller
public class InventoryController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDao oerderDao;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private ProductDao productDao;
	
	//판매 내역
	@GetMapping("/main/inventory/ordered")
	public String ordered(Model model) {
		List<Orders> orders = orderService.orderHistory();
		model.addAttribute(orders);
		return ("main/inventory/ordered");
	}
	
	//판매 내역 검색
	@PostMapping("/main/inventory/ordered")
	public String search(@ModelAttribute("orderId") int orderId, Model model) {
		Orders order = oerderDao.selectByOrderId(orderId);
		model.addAttribute(order);
		return("redirect:/main/inventory/ordered");
	}
	
	//환불
	@PostMapping("/main/inventory/ordered/{orderId}")
	public String delete(@PathVariable ("orderId") int orderId, Model model) {
		oerderDao.deleteOrder(orderId);
		return("redirect:/main/inventory/ordered");
	}
	
	//View
	@RequestMapping("/main/inventory")
	public String inventory(Model model) {
		List<Product> products = inventoryService.getAllProducts();
		model.addAttribute(products);
		return("/main/inventory");
	}
	
	@PostMapping("/main/inventory/regist")
	public String handleInventory(@ModelAttribute("product") Product product, Model model) throws Exception {
		inventoryService.regist(product);
		return("redirect:/main/inventory");
	}
	
	@PostMapping("/main/inventory/search")
	public String search(@ModelAttribute("productName") String productName, Model model) {
		Product product = productDao.selectByProductName(productName);
		model.addAttribute(product);
		return("redirect:/main/inventory");
	}
}
