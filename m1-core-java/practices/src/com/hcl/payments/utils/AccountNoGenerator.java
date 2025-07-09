package com.hcl.payments.utils;

import java.util.Random;

public class AccountNoGenerator {
	private static int accountNo;
	public static int generateAccountNo() {
		Random r=new Random();
		accountNo=(int) ((r.nextLong()*100L)+100L);
		return Math.abs(accountNo);
	}
}
