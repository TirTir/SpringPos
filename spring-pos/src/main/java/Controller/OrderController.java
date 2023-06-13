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
import dto.Orders;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderedProductService orderedProductService;
	@Autowired
	private OrderService orderService;
	
	@GetMapping
    public String showOrder(Model model) {
        List<Orders> orderList = orderDao.selectAllOrders();
        model.addAttribute("orders", orderList);
        return "order";
    }
	
	@GetMapping("/addToCart")
	public String insert(Model model) {
		model.addAttribute("OrderedRequest", new OrderedRequest());
        return "order";
    }
	
	@PostMapping("/addToCart")
	public String handleInsert(@ModelAttribute("OrderedRequest") OrderedRequest req, Model model){
		try {
            long totalPrice = orderedProductService.regist(req);
            model.addAttribute("totalPrice", totalPrice);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
		
		return "redirect: /order";
	}
	
	@PostMapping("/cancel")
	public String cancel(@ModelAttribute("number") int number, Model model){
		try {
			orderedProductService.cancel(number);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
		
		return "order";
	}
	
	@PostMapping("/regist")
	public String regist(Model model){
		try {
			orderService.regist();
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
		
		return "order";
	}
}