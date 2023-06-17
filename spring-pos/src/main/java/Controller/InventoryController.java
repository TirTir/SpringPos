package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.ProductRegisterRequest;

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
	public String ㅇ딛ㅅㄷ(@ModelAttribute("orderId") int orderId, Model model) {
		Orders order = oerderDao.selectByOrderId(orderId);
		model.addAttribute(order);
		return("redirect:/main/inventory/ordered");
	}
//	@Autowired
//	private ProductDao productDao;
//
//	@GetMapping
//    public String showInventory(Model model) {
//		List<Product> productList = productDao.selectAllProduct();
//	    model.addAttribute("products", productList);
//	    return "inventory";
//    }
//	
//	@PostMapping("/inventory/search")
//	public String search(@ModelAttribute("productName") String productName, Model model){
//		try {
//            Product product = productDao.selectByProductName(productName);
//            model.addAttribute("product", product);
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", e.getMessage());
//        }
//		
//		return "redirect:inventory";
//	}
//	
//	@GetMapping("/inventory/product")
//    public String regist(Model model) {
//		model.addAttribute("ProductRegisterRequest", new ProductRegisterRequest());
//        return "inventory";
//    }
//	
//    @RequestMapping(value = "/main-inventory", method = RequestMethod.GET)
//    public String showInventoryPage() {
//        return "redirect:inventory";
//    }
}
