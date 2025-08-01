package com.cetpa.utility;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component
public class DateTimeUtility 
{
	public String getCurrentDate()
	{
		LocalDate localDate=LocalDate.now();
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append(localDate.getDayOfMonth());
		stringBuffer.append("-");
		stringBuffer.append(localDate.getMonthValue());
		stringBuffer.append("-");
		stringBuffer.append(localDate.getYear());
		return stringBuffer.toString();
	}
	public String getCurrentTime()
	{
		LocalTime localTime=LocalTime.now();
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append(localTime.getHour());
		stringBuffer.append(":");
		stringBuffer.append(localTime.getMinute());
		stringBuffer.append(":");
		stringBuffer.append(localTime.getSecond());
		return stringBuffer.toString();
	}
}
