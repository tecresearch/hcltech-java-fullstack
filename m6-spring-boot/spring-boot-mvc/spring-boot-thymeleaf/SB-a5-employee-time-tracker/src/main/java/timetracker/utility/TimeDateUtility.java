package timetracker.utility;

import java.time.LocalTime;

public class TimeDateUtility 
{
	public static String getCurrentTime()
	{
		LocalTime lt=LocalTime.now();
		int h=lt.getHour();
		int m=lt.getMinute();
		int s=lt.getSecond();
		StringBuffer time=new StringBuffer();
		time.append(h<10?"0"+h:h);
		time.append(":");
		time.append(m<10?"0"+m:m);
		time.append(":");
		time.append(s<10?"0"+s:s);
		return time.toString();
	}
	public static String getTotalTime(String outtime,String intime)
	{
		int intimes=getTimeInSeconds(intime);
		int outtimes=getTimeInSeconds(outtime);
		int totals=intimes-outtimes;
		int h=totals/3600;
		int s=totals%3600;
		int m=s/60;
		s=s%60;
		String total=h+"hr,"+m+"min,"+s+"sec";
		return total;
	}
	private static int getTimeInSeconds(String time)
	{
		String[] x=time.split(":");
		int total=Integer.parseInt(x[0])*3600+Integer.parseInt(x[1])*60+Integer.parseInt(x[2]);
		return total;
	}
	public static String changeDateFormat(String date)
	{
		String[] x=date.split("-");
		return x[2]+"-"+x[1]+"-"+x[0];
	}
}
