package com.cetpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cetpa.model.Employee;
import com.cetpa.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("")
	public ModelAndView getEmployeeListView()
	{
		List<Employee> employeeList=employeeService.getList();
		ModelAndView modelAndView=new ModelAndView("employee-list");
		modelAndView.addObject("elist",employeeList);
		return modelAndView;
	}
	@GetMapping("add")
	public ModelAndView getAddEmployeeView()
	{
		ModelAndView modelAndView=new ModelAndView("insert-employee");
		return modelAndView;
	}
	@PostMapping("save-record")
	public String saveEmployeeRecord(Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	@GetMapping("delete-record")
	public String deleteEmployeeRecord(int eid)
	{
		employeeService.deleteEmployee(eid);
		return "redirect:/";
	}
	@GetMapping("edit-record")
	public ModelAndView getEditEmployeeView(int eid)
	{
		Employee employee=employeeService.getEmployee(eid);
		ModelAndView modelAndView=new ModelAndView("edit-employee");
		modelAndView.addObject("employee",employee);
		return modelAndView;
	}
	@PostMapping("update-record")
	public String updateEmployeeRecord(Employee employee)
	{
		employeeService.updateEmployee(employee);
		return "redirect:/";
	}
}
