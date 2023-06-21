package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.ProductRegisterRequest;
import com.example.demo.dao.ProductDao;
import com.example.demo.dto.Product;
import com.example.demo.service.ProductService;


@Controller
public class InventoryController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDao productDao;
	
	//View
	@GetMapping("/inventory")
	public String inventory(Model model) { //전체 상품
		List<Product> product = productDao.selectAllProduct();
		model.addAttribute("product", product);
		return("inventory");
	}
	
	//상품 추가
	@PostMapping("/inventory/regist")
	public String handleInventory(@ModelAttribute("productRegisterRequest") ProductRegisterRequest req, Model model) {
		
		try {
			productService.regist(req);
		} catch (Exception e) {
			model.addAttribute("message", e);
		}		
		return ("redirect:/inventory");
	}
	
	//상품 검색
	@GetMapping("/inventory/{search}")
	public String search(@PathVariable String search, Model model) {
		try {
			Product product = productService.search(search);
			model.addAttribute("products", product);
		}catch (Exception e) {
			model.addAttribute("message", "상품이 존재하지 않습니다.");
		}
		
		return("inventory");
	}
}
