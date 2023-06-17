package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.StatisticsProductResponse;
import com.example.demo.StatisticsResponse;

import Service.StatisticPeriodService;
import Service.StatisticProductService;

@Controller
public class StatisticsController {
	@Autowired
	StatisticPeriodService statisticPeriodService;
	@Autowired
	StatisticProductService statisticProductService;
	
	//View
	@RequestMapping("/statistic")
	public String showStatistic() {
		return "statistic";
	}
	
	//View
	@RequestMapping("statistic/period")
	public String period(Model model){
		return "statistic/period";
	}

	//View
	@RequestMapping("statistic/product")
	public String product(Model model){
		List<StatisticsProductResponse> statistics = statisticProductService.getProductRankings();
		model.addAttribute("statistics", statistics);
		return "statistic/product";
	}
	
	//View
	@RequestMapping("statistic/period/period")
	public String showPeriod(Model model){
		return "statistic/period/period";
	}
	
	//기간별 분석
	@PostMapping("statistic/period/period/{period}")
	public String handlePeriod(@PathVariable String period, Model model) {
		StatisticsResponse statistic;

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
	            return "redirect:/statistic/period/";
	    }
	    
	    model.addAttribute("statistics", statistic);
		return "redirect:/statistic/period/period";
	}
}
