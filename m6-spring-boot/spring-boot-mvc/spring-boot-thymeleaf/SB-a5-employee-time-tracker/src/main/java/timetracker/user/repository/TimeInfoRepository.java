package timetracker.user.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import timetracker.user.entity.TimeInfo;

public interface TimeInfoRepository extends JpaRepository<TimeInfo,Integer>
{
	@Query("from TimeInfo where empId=:arg1 and intime=:arg2")
	TimeInfo getTimeinfo(@Param("arg1") int empId,@Param("arg2") String intime);

	@Query("from TimeInfo where date=:arg")
	List<TimeInfo> findAllSpecifiedDate(@Param("arg") LocalDate date);
}
