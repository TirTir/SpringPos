package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.demo.UserAuthResponse;

import javax.servlet.http.HttpSession;
@Controller
public class MainController {
	@Autowired
	private HttpSession session;
	
	@RequestMapping({"/", "/main"})
	public String main(){ return "main"; }
	
	@GetMapping({"/", "/main"})
    public String showMainPage(Model model, @SessionAttribute("user") UserAuthResponse user) {
		model.addAttribute("userName", user.getUserName());
        return "main";
    }
	
	@GetMapping({"/", "/main"})
	public String logout(Model model, @ModelAttribute("logout") String logout){
		session.removeAttribute("user");
		return "login";
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
