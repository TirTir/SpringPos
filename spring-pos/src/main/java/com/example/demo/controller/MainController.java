package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	//View
	@GetMapping({"/main"})
	public String main() {
        return ("main");
    }
	
	@GetMapping("main/logout")
	public String logout(Model model) {
        return ("login");
    }	
}
