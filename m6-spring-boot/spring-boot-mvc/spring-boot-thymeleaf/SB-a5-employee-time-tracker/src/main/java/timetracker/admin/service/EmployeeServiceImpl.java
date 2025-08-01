package timetracker.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timetracker.admin.entity.Employee;
import timetracker.admin.repository.DepartmentRepository;
import timetracker.admin.repository.EmployeeRepository;
import timetracker.admin.repository.RoleRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired private RoleRepository roleRepository;
	@Autowired private DepartmentRepository departmentRepository;
	private EmployeeRepository employeeRepository;
	public EmployeeServiceImpl(EmployeeRepository employeeRepository)
	{
		this.employeeRepository=employeeRepository;
	}
	public void saveEmployee(Employee employee) 
	{
		employeeRepository.save(employee);
	}
	public List<Employee> getList()
	{
		return employeeRepository.findAll();
	}
	public Employee getEmployee(int eid)
	{
		return employeeRepository.findById(eid).orElse(null);
	}
	public Map<String, String> getEmployeeByIdDelete(int eid) 
	{
		Employee emp=employeeRepository.findById(eid).orElse(null);
		Map<String,String> map=getEmployeeById(emp);
		map.put("department",departmentRepository.getDepartment(emp.getDeptId()));
		map.put("role",roleRepository.getRole(emp.getRoleId()));
		return map;
	}
	public Map<String, String> getEmployeeByIdEdit(int eid) 
	{
		Employee emp=employeeRepository.findById(eid).orElse(null);
		return getEmployeeById(emp);
	}
	private Map<String, String> getEmployeeById(Employee emp) 
	{
		
		Map<String,String> map=new HashMap<>();
		if(emp==null)
			map.put("msg","Employee does not exist");
		else
		{
			map.put("firstname",emp.getFirstname());
			map.put("lastname",emp.getLastname());
			map.put("email",emp.getEmail());
			map.put("phone",emp.getPhone());
			map.put("department",String.valueOf(emp.getDeptId()));
			map.put("role",String.valueOf(emp.getRoleId()));
			map.put("timein",emp.getTimein());
			map.put("timeout",emp.getTimeout());
		}
		return map;
	}
	public void deleteEmployee(int eid) 
	{
		employeeRepository.deleteById(eid);
	}
}
