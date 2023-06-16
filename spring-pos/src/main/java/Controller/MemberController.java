package Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.UserAuthRequest;
import com.example.demo.UserRegisterRequest;

import Service.UserAuthService;
import dto.Member;

@Controller
public class MemberController {
	@Autowired
	private UserAuthService userAuthService;	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mav) {
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView handleLogin(@RequestParam UserAuthRequest req, ModelAndView mav) {
		
		try {
			Member member = userAuthService.login(req);
			mav.addObject("User", member);
			mav.setViewName("main");
		} catch (Exception e) {
			mav.addObject("msg", e);
			mav.setViewName("login");
		}		
		return mav;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public ModelAndView join(ModelAndView mav) {
		mav.setViewName("join");
		return mav;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public ModelAndView handleJoin(@RequestParam UserRegisterRequest req, ModelAndView mav) throws Exception {
		userAuthService.join(req);
		mav.setViewName("login");
		return mav;
	}
}
