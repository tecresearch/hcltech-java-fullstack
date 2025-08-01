package timetracker.user.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timetracker.admin.repository.EmployeeRepository;
import timetracker.user.entity.TimeInfo;
import timetracker.user.repository.TimeInfoRepository;
import timetracker.utility.TimeDateUtility;

@Service
public class TimeInfoServiceImpl implements TimeInfoService
{
	@Autowired private TimeInfoRepository timeInfoRepository;
	@Autowired private EmployeeRepository employeeRepository;

	public void saveTimeOut(TimeInfo timeInfo) 
	{
		timeInfo.setOutime(TimeDateUtility.getCurrentTime());
		timeInfo.setDate(LocalDate.now());
		timeInfoRepository.save(timeInfo);
		
		employeeRepository.updateStatus("out",timeInfo.getEmpId());
	}

	public void updateTimeIn(int empId) 
	{
		TimeInfo timeInfo=timeInfoRepository.getTimeinfo(empId,"Not in yet");
		String intime=TimeDateUtility.getCurrentTime();
		String totaltime=TimeDateUtility.getTotalTime(timeInfo.getOutime(),intime);
		timeInfo.setIntime(intime);
		timeInfo.setTotaltime(totaltime);
		timeInfoRepository.save(timeInfo);
		employeeRepository.updateStatus("in",empId);
	}
}
