package timetracker.admin.service;

import java.util.List;
import java.util.Map;

import timetracker.admin.entity.Employee;


public interface EmployeeService 
{
	void saveEmployee(Employee employee);
	List<Employee> getList();
	Employee getEmployee(int eid);
	Map<String, String> getEmployeeByIdDelete(int eid);
	Map<String, String> getEmployeeByIdEdit(int eid);
	void deleteEmployee(int eid);
}
