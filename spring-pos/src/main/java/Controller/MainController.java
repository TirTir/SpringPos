package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	//View
	@GetMapping("/main")
	public ModelAndView main(ModelAndView mav) {
		mav.setViewName("main");
        return mav;
    }
	
	@GetMapping("/main/logout")
	public ModelAndView logout(ModelAndView mav) {
		mav.setViewName("login");
        return mav;
    }
	
}
