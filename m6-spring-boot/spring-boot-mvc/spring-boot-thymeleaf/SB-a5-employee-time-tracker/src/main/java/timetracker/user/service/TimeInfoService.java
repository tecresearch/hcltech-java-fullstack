package timetracker.user.service;

import timetracker.user.entity.TimeInfo;

public interface TimeInfoService 
{
	void saveTimeOut(TimeInfo timeInfo);
	void updateTimeIn(int empId);
}
