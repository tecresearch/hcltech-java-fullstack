package timetracker.user.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import timetracker.user.entity.TimeInfo;
import timetracker.user.service.ReportService;

@Controller
@RequestMapping("user/datewise/report")
public class DatewiseReportController 
{
	@Autowired private ReportService reportService;
	
	@GetMapping("currentdate")
	public String getCurrentDateView(Model model)
	{
		List<TimeInfo> currentDateList=reportService.getSpecifiedDateReport(LocalDate.now());
		model.addAttribute("currentDateList",currentDateList);
		return "user/reports/datewise/currentdate-dashboard";
	}
	@GetMapping("anydate")
	public String getAnyDateView(Model model,String date)
	{
		List<TimeInfo> anyDateList=reportService.getSpecifiedDateReport(LocalDate.parse(date));
		model.addAttribute("anyDateList",anyDateList);
		model.addAttribute("date",date);
		return "user/reports/datewise/anydate-dashboard";
	}
}
