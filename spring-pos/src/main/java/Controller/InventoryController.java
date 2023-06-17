package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Service.OrderService;
import dao.OrderDao;
import dto.Orders;

@Controller
public class InventoryController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDao oerderDao;
	
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
}
