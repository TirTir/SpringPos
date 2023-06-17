package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.OrderedRequest;

import Service.OrderService;
import Service.OrderedProductService;
import dao.OrderDao;
import dao.OrderedProductDao;
import dto.OrderedProduct;

@Controller
public class OrderController {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderedProductService orderedProductService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderedProductDao orderedProductDao;

	//View
	@RequestMapping("main/order")
	public String order(Model model) {
		int orderId = orderDao.getNextOrderId();
		List<OrderedProduct> orders = orderedProductDao.selectByOrderId(orderId);
		model.addAttribute("orders", orders);
        return "/main/order";
    }
	
	//담기
	@PostMapping("main/order")
	public String handleOrder(@ModelAttribute("orderedRequest") OrderedRequest req, Model model) {
		try {
			long totalPrice = orderedProductService.regist(req);
			model.addAttribute(totalPrice);

		} catch (Exception e) {
			model.addAttribute("msg", e);
		}		
		return ("redirect:/main/order");
    }
	
	//반품
	@GetMapping("/main/order/cancel/{num}")
	public String cancel(@PathVariable  int num, Model model) {
		try {
			orderedProductService.cancel(num);
		} catch (Exception e) {
			model.addAttribute("msg", e);
		}		
		return ("redirect:/main/order");
    }
	
	//결제하기
	@GetMapping("/main/order/regist")
	public String regist(Model model) {
		try {
			orderService.regist();
		} catch (Exception e) {
			model.addAttribute("msg", e);
		}		
		return ("redirect:/main/order");
	}

}
