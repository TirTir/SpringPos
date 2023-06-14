package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.UserAuthRequest;
import com.example.demo.UserAuthResponse;

import Service.UserAuthService;
import dao.MemberDao;
import dto.Member;

@Controller
public class MemberController {
	@Autowired
    private MemberDao memberDao;
	@Autowired
	private UserAuthService userAuthService;
	
	@GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login";
    }
	
	@PostMapping("/login")
	public String Login(@RequestParam(value="agree", defaultValue="false") Boolean agree, Model model){
		if(!agree) {
			return "login";
		}
		model.addAttribute("userAuthRequest", new UserAuthRequest());
		return "/process";
	}
	
	@PostMapping("/login/process")
	public String handleLogin(UserAuthRequest req, Model model){
		try {
			UserAuthResponse res = userAuthService.login(req);
			model.addAttribute("userAuthResponse", res);
	        return "main";
        } catch (Exception e) {
            return "login";
        }
	}
	
	@GetMapping("/join")
    public String showJoinPage(Model model) {
        return "join";
    }
	
	@PostMapping("/join")
	public String Join(@RequestParam(value="agree", defaultValue="false") Boolean agree, Model model){
		if(!agree) {
			return "join";
		}
		model.addAttribute("member", new Member());
		return "/process";
	}
	
	@PostMapping("/join/process")
	public String handleJoin(@ModelAttribute("member") Member member, Model model){
		try {
			memberDao.insert(member);
	        return "main";
        } catch (Exception e) {
            return "join";
        }
	}
}
