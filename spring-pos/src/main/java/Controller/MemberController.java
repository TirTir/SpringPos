package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.UserAuthRequest;

import Service.UserAuthService;
import dao.MemberDao;
import dto.Member;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
    private MemberDao memberDao;
	@Autowired
	private UserAuthService userAuthService;
    
	@GetMapping("/login")
    public String login(Model model) {
		model.addAttribute("UserAuthRequest", new UserAuthRequest());
        return "login";
    }
	
	@PostMapping("/login")
	public String handleLogin(@ModelAttribute("userAuthRequest") UserAuthRequest req, Model model){
		try {
            String userName = userAuthService.login(req);
            model.addAttribute("userName", userName);
            return "home";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "login";
        }
	}
	
	@GetMapping("/join")
    public String join(Model model) {
        List<Member> memberList = memberDao.selectAllMembers();
        model.addAttribute("members", memberList);
        return "join";
    }
}
