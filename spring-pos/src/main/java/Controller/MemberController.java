package Controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.UserAuthRequest;
import com.example.demo.UserRegisterRequest;

import Service.UserAuthService;
import dao.MemberDao;
import dto.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private UserAuthService userAuthService;	
	
	@GetMapping("/")
	public String root() throws Exception {
		return "redirect:login";
	}
	
	@GetMapping("/setting")
	public String setting(Model model) {
		List<Member> users = memberDao.selectAllMembers();
		model.addAttribute("users", users);
		return "setting";
	}
	
	@PostMapping("/login")
	public String handleLogin(@ModelAttribute("userAuthRequest") UserAuthRequest req, HttpSession session, Model model) {
		try {
			Member member = userAuthService.login(req);
			session.setAttribute("user", member);
		} catch (Exception e) {
			model.addAttribute("msg", e);
			return ("login");
		}		
		return "/main";
	}
	
	@GetMapping("/join")
	public String join(Model model) {
		return ("join");
	}
	
	@PostMapping("/join")
	public String handleJoin(@RequestParam UserRegisterRequest req, ModelAndView mav) throws Exception {
		userAuthService.join(req);
		return ("login");
	}
	
	@PostMapping("/setting")
	public String search(@RequestParam String userName, Model model) {
		Member user = memberDao.selectByUserName(userName);
		model.addAttribute("user", user);
		return ("redirect:/main/setting");
	}
	
}
