package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.ProductRegisterRequest;

import dao.ProductDao;
import dto.Product;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
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
