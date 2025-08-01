package timetracker.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import timetracker.admin.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>
{
	@Query("select deptName from Department where deptId=:arg")
	String getDepartment(@Param("arg") int deptId);
}