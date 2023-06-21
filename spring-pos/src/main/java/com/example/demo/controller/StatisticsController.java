package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.StatisticsProductResponse;
import com.example.demo.StatisticsResponse;
import com.example.demo.service.StatisticPeriodService;
import com.example.demo.service.StatisticProductService;

@Controller
public class StatisticsController {
	@Autowired
	StatisticPeriodService statisticPeriodService;
	@Autowired
	StatisticProductService statisticProductService;
	
	//View
	@GetMapping("/statistic")
	public String showStatistic(Model model) {
		return "statistic";
	}
	
	//Period View
	@GetMapping("/period")
	public String period(Model model){
		return "period";
	}

	//기간별 분석
	@GetMapping("/periodStats/{period}")
	public String handlePeriod(@PathVariable String period, Model model) {
		List<StatisticsResponse> statistic;

	    switch (period) {
	        case "monthly":
	        	statistic = statisticPeriodService.getMonthlyOrderStatistics();
	            break;
	        case "weekly":
	        	statistic = statisticPeriodService.getWeeklyOrderStatistics();
	            break;
	        case "daily":
	        	statistic = statisticPeriodService.getDailyOrderStatistics();
	            break;
	        default:
	            return "periodStats";
	    }
	    model.addAttribute("statistics", statistic);
		return "periodStats";
	}

	//Product View
	@GetMapping("/product")
	public String product(Model model){
		List<StatisticsProductResponse> statistics = statisticProductService.getProductRankings();
		model.addAttribute("statistics", statistics);
		return "product";
	}
}
