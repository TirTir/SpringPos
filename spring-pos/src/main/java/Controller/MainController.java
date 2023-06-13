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
	
	@PostMapping("/statistic")
    public String statistic(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
        if (!agree) {
            return "main";
        }
        return "redirect:/statistic";
    }

    @PostMapping("/order")
    public String order(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
        if (!agree) {
            return "main";
        }
        return "redirect:/order";
    }
    
    @PostMapping("/inventory")
    public String inventory(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
    	if (!agree) {
            return "main";
        }
    	return "redirect:/inventory";
    }
}
