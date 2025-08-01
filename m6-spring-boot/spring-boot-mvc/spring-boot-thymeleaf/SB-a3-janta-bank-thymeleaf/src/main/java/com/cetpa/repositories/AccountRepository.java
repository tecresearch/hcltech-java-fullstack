package com.cetpa.repositories;

import com.cetpa.models.Account;

public interface AccountRepository 
{
	void persistAccount(Account account);
	int getAccountNoByUserId(String userid);
	int getAmount(int accountno);
	void updateAmount(int amount, int accountno);
	String getNameByAccountno(int accountno);
}
