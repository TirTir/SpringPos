package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@GetMapping({"/", "/main"})
	public String showMainPage(Model model){ 
		return "main"; 
		}

    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }
}
