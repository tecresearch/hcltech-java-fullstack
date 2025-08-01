package com.cetpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.cetpa.entity.Employee;
import com.cetpa.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("")
	public String getHomeView()
	{
		return "home";
	}
	@GetMapping("insert-employee")
	public String getInsertView()
	{
		return "add";
	}
	@PostMapping("save-record")
	public String saveEmployeeRecord(Employee employee)
	{
		employeeService.saveRecord(employee);
		return "save";
	}
	@GetMapping("employee-list")
	public String getEmployeeList(Model model)
	{
		List<Employee> employeeList=employeeService.getList();
		model.addAttribute("elist",employeeList);
		return "list";
	}
	@GetMapping("search-employee")
	public String getSearchView()
	{
		return "search";
	}
	@GetMapping("search-record")
	public String searchEmployeeRecord(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
		{
			model.addAttribute("msg","Record not found");
			model.addAttribute("eid",eid);
			return "search";
		}
		model.addAttribute("emp", employee);
		return "show-record";
	}
	@GetMapping("delete-employee")
	public String getDeleteView()
	{
		return "delete";
	}
	@GetMapping("confirm-delete")
	public String confirmDeleteEmployeeRecord(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
		{
			model.addAttribute("msg","Record does not exist");
			model.addAttribute("eid",eid);
			return "delete";
		}
		model.addAttribute("emp", employee);
		return "confirm";
	}
	@GetMapping("delete-record")
	public String deleteEmployeeRecord(int eid)
	{
		employeeService.deleteRecord(eid); 
		return "delete-success";
	}
	@GetMapping("edit-employee")
	public String getEditView()
	{
		return "edit";
	}
	@GetMapping("show-record")
	public String showDeleteEmployeeRecord(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
		{
			model.addAttribute("msg","Record does not exist");
			model.addAttribute("eid",eid);
			return "edit";
		}
		model.addAttribute("emp", employee);
		return "update-show";
	}
	@PostMapping("update-record")
	public String updateEmployeeRecord(Employee employee)
	{
		employeeService.updateRecord(employee);
		return "update-success";
	}
}
