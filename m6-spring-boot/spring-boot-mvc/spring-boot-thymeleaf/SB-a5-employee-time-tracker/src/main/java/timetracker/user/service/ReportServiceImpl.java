package timetracker.user.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timetracker.user.entity.TimeInfo;
import timetracker.user.repository.TimeInfoRepository;

@Service
public class ReportServiceImpl implements ReportService 
{
	@Autowired private TimeInfoRepository timeInfoRepository;

	public List<TimeInfo> getSpecifiedDateReport(LocalDate date) 
	{
		return timeInfoRepository.findAllSpecifiedDate(date);
	}
	
}
