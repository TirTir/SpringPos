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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
    private MemberDao memberDao;
	@Autowired
	private UserAuthService userAuthService;
    
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/login")
    public String login(Model model) {
		model.addAttribute("userAuthRequest", new UserAuthRequest());
        return "login";
    }
	
	@PostMapping("/login")
	public String handleLogin(@ModelAttribute("userAuthRequest") UserAuthRequest req, Model model, HttpServletRequest request){
		try {
			UserAuthResponse res = userAuthService.login(req);
			
            HttpSession session = request.getSession();
            session.setAttribute("user", res);
            return "main";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "login";
        }
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String showJoinPage() {
		return "join";
	}
	
	@GetMapping("/join")
    public String join(Model model) {
		model.addAttribute("Member", new Member());
        return "join";
    }
	
	@PostMapping("/join")
	public String handleJoin(@ModelAttribute("member") Member member, Model model){
		memberDao.insert(member);
		return "login";
        } 
}
