package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.OrderedRequest;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.OrderedProductDao;
import com.example.demo.dto.OrderedProduct;
import com.example.demo.dto.Orders;
import com.example.demo.service.OrderService;
import com.example.demo.service.OrderedProductService;

@Controller
public class OrderController {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderedProductDao orderedProductDao;
	@Autowired
	private OrderedProductService orderedProductService;

	//View
	@GetMapping("/order")
	public String order(Model model) {
		int orderId = orderDao.getNextOrderId();
		List<OrderedProduct> orders = orderedProductDao.selectByOrderId(orderId);
		model.addAttribute("orders", orders);
        return "order";
    }
	
	//담기
	@PostMapping("/order")
	public String handleOrder(@ModelAttribute("orderedRequest") OrderedRequest req, Model model) throws Exception {
		try {
			long totalPrice = orderedProductService.regist(req);
			model.addAttribute("totalPrice", totalPrice);
		} catch (Exception e) {
	        model.addAttribute("message", e);
		}		
		return ("order");
    }
	
	//반품
	@GetMapping("/main/order/cancel/{num}")
	public String cancel(@PathVariable  int num, Model model) {
		try {
			orderedProductService.cancel(num);
		} catch (Exception e) {
			model.addAttribute("msg", e);
		}		
		return ("redirect:/main/order");
    }
	
	//결제하기
	@GetMapping("/regist")
	public String regist(Model model) {
		try {
			orderService.regist();
		} catch (Exception e) {
			model.addAttribute("msg", e);
		}		
		return ("redirect:/order");
	}
	
	//판매 내역
	@GetMapping("/ordered")
	public String ordered(Model model) {
		List<Orders> orders = orderService.orderHistory();
		model.addAttribute(orders);
		return ("ordered");
	}
	
	//판매 내역 검색
	@PostMapping("/ordered/search")
	public String search(@ModelAttribute int orderId, Model model) throws Exception {
		Orders order = orderDao.selectByOrderId(orderId);
		if(order != null) {
			model.addAttribute(order);
		}else {
			throw new Exception("존재하지 않는 내역입니다.");
		}
		return("ordered");
	}
	
	//환불
	@PostMapping("/delete/{orderId}")
	public String delete(@PathVariable ("orderId") int orderId, Model model) {
		orderDao.deleteOrder(orderId);
		return("redirect:/ordered");
	}
}
