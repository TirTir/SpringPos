package Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.UserAuthRequest;
import com.example.demo.UserRegisterRequest;

import Service.UserAuthService;
import dto.Member;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
	@Autowired
	private UserAuthService userAuthService;	
	
	@RequestMapping("/")
	public String root() throws Exception {
		return "redirect:login";
	}
	
	@PostMapping("/login")
	public String handleLogin(@ModelAttribute("userAuthRequest") UserAuthRequest req, Model model) {
		String page = "login";
		try {
			Member member = userAuthService.login(req);
			page = "main";
		} catch (Exception e) {
			model.addAttribute("msg", e);
		}		
		return page;
	}
	
	@GetMapping("/join")
	public ModelAndView join(ModelAndView mav) {
		mav.setViewName("join");
		return mav;
	}
	
	@PostMapping("/join")
	public ModelAndView handleJoin(@RequestParam UserRegisterRequest req, ModelAndView mav) throws Exception {
		userAuthService.join(req);
		mav.setViewName("login");
		return mav;
	}
}
