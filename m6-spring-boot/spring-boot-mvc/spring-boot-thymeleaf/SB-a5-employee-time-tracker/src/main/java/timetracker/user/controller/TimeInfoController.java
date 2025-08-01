package timetracker.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import timetracker.admin.entity.Employee;
import timetracker.admin.repository.EmployeeRepository;
import timetracker.user.entity.TimeInfo;
import timetracker.user.service.TimeInfoService;

@Controller
@RequestMapping("user/time")
public class TimeInfoController 
{
	@Autowired private TimeInfoService timeInfoService;
	@Autowired private EmployeeRepository employeeRepository;
	
	@GetMapping("employee-inlist")
	@ResponseBody
	public Map<Integer,String> getEmployeeNameInList()
	{
		List<Employee> employeeList=employeeRepository.findAll("in");
		Map<Integer,String> map=new HashMap<>();
		for(Employee emp:employeeList)
		{
			map.put(emp.getEmpId(),emp.getFirstname()+" "+emp.getLastname());
		}
		return map;
	}
	@GetMapping("record-timeout")
	public String recordTimeOut(TimeInfo timeInfo)
	{
		timeInfoService.saveTimeOut(timeInfo);
		return "redirect:outSuccess";
	}
	
	@GetMapping("employee-outlist")
	@ResponseBody
	public Map<Integer,String> getEmployeeNameOutList()
	{
		List<Employee> employeeList=employeeRepository.findAll("out");
		Map<Integer,String> map=new HashMap<>();
		for(Employee emp:employeeList)
		{
			map.put(emp.getEmpId(),emp.getFirstname()+" "+emp.getLastname());
		}
		return map;
	}
	@GetMapping("update-timein")
	public String updateTimeIn(int empId)
	{
		timeInfoService.updateTimeIn(empId);
		return "redirect:inSuccess";
	}
	@GetMapping("outSuccess")
	public String outSuccessView(Model model)
	{
		model.addAttribute("msg","Employee time out has been recorded successfully");
		return "user/home/user-home";
	}
	@GetMapping("inSuccess")
	public String inSuccessView(Model model)
	{
		model.addAttribute("msg","Employee time in has been updated successfully");
		return "user/home/user-home";
	}
}
