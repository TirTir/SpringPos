package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.UserAuthRequest;
import com.example.demo.UserRegisterRequest;
import com.example.demo.dao.MemberDao;
import com.example.demo.service.UserAuthService;



import com.example.demo.dto.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private UserAuthService userAuthService;	
	
	@GetMapping( {"/","/login"} )
	public String login(){
		return "login";
		}
	
	@PostMapping("/login")
	public String handleLogin(@ModelAttribute("userAuthRequest") UserAuthRequest req, Model model) {
		Member user;
		try {
			user = userAuthService.login(req);
		} catch (Exception e) {
			model.addAttribute("message", e);
			return ("redirect:/login");
		}		
		model.addAttribute("user", user);
		return "main";
	}
	
	@GetMapping("/logout")
	public String join() {
		return ("redirect:/login");
	}
	
	@GetMapping("/join")
	public String join(Model model) {
		return ("/join");
	}
	
	@PostMapping("/join")
	public String handleJoin(@ModelAttribute("userRegisterRequest") UserRegisterRequest req, Model model) {
		userAuthService.join(req);
		return ("login");
	}
	
	@GetMapping("/setting")
	public String setting(Model model) {
		List<Member> users = memberDao.selectAllMembers();
		model.addAttribute("users", users);
		return "setting";
	}
	
	@PostMapping("/setting")
	public String search(@RequestParam String userName, Model model) {
		Member user = memberDao.selectByUserName(userName);
		model.addAttribute("user", user);
		return ("setting");
	}
	
	@GetMapping("/setting/delete/{userId}")
	public String setting(@PathVariable String userId, Model model) {
		memberDao.deleteMember(userId);
		return "setting";
	}
}
