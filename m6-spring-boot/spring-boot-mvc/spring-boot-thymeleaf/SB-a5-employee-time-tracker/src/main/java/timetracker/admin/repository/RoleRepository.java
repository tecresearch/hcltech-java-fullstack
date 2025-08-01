package timetracker.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import timetracker.admin.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>
{
	@Query("from Role where department.deptId=:arg")
	List<Role> findAllByDept(@Param("arg") int deptId);

	@Query("select role from Role where rid=:arg")
	String getRole(@Param("arg") int roleId);
}
