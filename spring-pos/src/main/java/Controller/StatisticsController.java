package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.StatisticsProductResponse;
import com.example.demo.StatisticsResponse;

import Service.StatisticProductService;
import Service.StatisticService;

@Controller
@RequestMapping("/statistic")
public class StatisticsController {
//	@Autowired
//	private StatisticService statisticService;
//	@Autowired
//	private StatisticProductService statisticProductService;
//	
//	@GetMapping
//    public String showStatisticPage(Model model) {
//	    return "statistic";   
//    }
//	
//	@PostMapping("/period")
//	public String periodStatistic(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
//        if (!agree) {
//            return "statistic";
//        }
//        return "redirect:/period";
//    }
//	
//	@PostMapping("/period/monthly")
//	public String monthlyStatistic(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
//		try {
//			StatisticsResponse res = statisticService.monthlyOrderStatistics();
//			model.addAttribute("StatisticsResponse", res);
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", e.getMessage());
//        }
//		
//		return "/period";
//	}
//	
//	@PostMapping("/period/weekly")
//	public String weeklyStatistic(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
//		try {
//			StatisticsResponse res = statisticService.weeklyOrderStatistics();
//			model.addAttribute("StatisticsResponse", res);
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", e.getMessage());
//        }
//		
//		return "/period";
//	}
//	
//	@PostMapping("/period/daily")
//	public String dailyStatistic(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
//		try {
//			StatisticsResponse res = statisticService.dailyOrderStatistics();
//			model.addAttribute("StatisticsResponse", res);
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", e.getMessage());
//        }
//		
//		return "/period";
//	}
//	
//	@PostMapping("/product")
//	public String productStatistic(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
//		try {
//			List<StatisticsProductResponse> statisticsList = statisticProductService.getProductRankings();
//			model.addAttribute("statisticsList", statisticsList);
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", e.getMessage());
//        }
//		
//		return "/product";
//	}
}
