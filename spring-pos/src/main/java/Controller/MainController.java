package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value="/user/main", method=RequestMethod.GET)
	public ModelAndView main(ModelAndView mav) {
		mav.setViewName("main");
        return mav;
    }
	
	@RequestMapping(value="/user/main/logout", method=RequestMethod.GET)
	public ModelAndView logout(ModelAndView mav) {
		mav.setViewName("login");
        return mav;
    }
	
}
