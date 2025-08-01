package timetracker.user.service;

import java.time.LocalDate;
import java.util.List;

import timetracker.user.entity.TimeInfo;

public interface ReportService 
{
	List<TimeInfo> getSpecifiedDateReport(LocalDate now);
}
