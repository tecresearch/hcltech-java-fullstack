package com.hcl.date_api;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class TimePeriod {

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("years: ");
		int years=sc.nextInt();
		System.out.println("months: ");
		int months=sc.nextInt();
		System.out.println("days: ");
		int days=sc.nextInt();
		System.out.println(getCurrentTimePeriod(years,months,days));

	}

	

	private static String getCurrentTimePeriod(int years, int months, int days) {
		
	   LocalDate	local=LocalDate.now();
		
		Period year=Period.ofYears(years);
		Period month=Period.ofMonths(months);
		Period day=Period.ofDays(days);
		
		int cy=local.getYear();
		int my=local.getMonth().getValue();
		int dy=local.getDayOfMonth();
		
		Period py=year.minusYears(cy);
		Period pm=month.minusMonths(my);
		Period pd=day.minusDays(dy);
		
		String currentTimePeriod="Current Time Period: "+pd.getDays()+pm.getMonths()+py.getYears();
		
		
		return currentTimePeriod;
	}

}
