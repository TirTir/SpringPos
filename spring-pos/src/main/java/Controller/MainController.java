package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
   
	@RequestMapping({"/", "/main"})
	public String main(){ return "main"; }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/logout")
	public String logout(Model model){
		return "redirect:/";
	}
	
	@RequestMapping(value = "/statistic", method = RequestMethod.GET)
	public String showStatisticPage() {
		return "statistic";
	}
	
	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public String showInventoryPage() {
		return "inventory";
	}
}
