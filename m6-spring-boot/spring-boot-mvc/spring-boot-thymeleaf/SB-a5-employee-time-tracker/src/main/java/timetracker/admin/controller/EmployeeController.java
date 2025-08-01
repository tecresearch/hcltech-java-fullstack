package timetracker.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import timetracker.admin.entity.Department;
import timetracker.admin.entity.Employee;
import timetracker.admin.entity.Role;
import timetracker.admin.repository.DepartmentRepository;
import timetracker.admin.repository.RoleRepository;
import timetracker.admin.service.EmployeeService;

@Controller
@RequestMapping("admin/employee")
public class EmployeeController 
{
	@Autowired private EmployeeService employeeService;
	@Autowired private DepartmentRepository departmentRepository;
	@Autowired private RoleRepository roleRepository;
	
	@GetMapping("dashboard")
	public ModelAndView getEmployeeDashboardView()
	{
		List<Employee> employeeList=employeeService.getList();
		ModelAndView modelAndView=new ModelAndView("admin/dashboard/employee/employee-dashboard");
		modelAndView.addObject("empList",employeeList);
		return modelAndView;
	}
	@GetMapping("department-list")
	@ResponseBody
	public Map<Integer,String> getDepartmentList()
	{
		List<Department> list=departmentRepository.findAll();
		Map<Integer,String> map=new HashMap<>();
		for(Department dept:list)
			map.put(dept.getDeptId(),dept.getDeptName());
		return map; 
	}
	@GetMapping("role-list")
	@ResponseBody
	public Map<Integer,String> getRoleListByDept(int deptId)
	{
		List<Role> list=roleRepository.findAllByDept(deptId);
		Map<Integer,String> map=new HashMap<>();
		for(Role role:list)
			map.put(role.getRid(),role.getRole());
		return map; 
	}
	@PostMapping("add-employee")
	public String addEmployee(Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:dashboard";
	}
	@GetMapping("get-employee-edit")
	@ResponseBody
	public Map<String,String> getEmployeeDetailsEdit(int eid)
	{
		return employeeService.getEmployeeByIdEdit(eid);
	}
	@GetMapping("get-employee-delete")
	@ResponseBody
	public Map<String,String> getEmployeeDetailsDelete(int eid)
	{
		return employeeService.getEmployeeByIdDelete(eid);
	}
	@GetMapping("delete-employee")
	public String deleteEmployee(int eid)
	{
		employeeService.deleteEmployee(eid);
		return "redirect:dashboard";
	}
	@PostMapping("update-employee")
	public String updateEmployee(Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:dashboard";
	}
	@GetMapping("get-employee-list")
	@ResponseBody
	public List<Employee> getEmployeeList()
	{
		List<Employee> employeeList=employeeService.getList();
		return employeeList;
	}
}
