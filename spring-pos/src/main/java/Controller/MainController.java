package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.UserAuthResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class MainController {

	@RequestMapping({"/", "/main"})
	public String main(){ return "main"; }
	
	@GetMapping({"/", "/main"})
    public String showMainPage(Model model, @SessionAttribute("user") UserAuthResponse user, HttpServletRequest request) {
		model.addAttribute("userName", user.getUserName());
        
		return "main";
    }
	
	@GetMapping({"/logout"})
	public String logout(Model model, @ModelAttribute("logout") String logout, HttpServletRequest request){
		HttpSession session = request.getSession();
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
