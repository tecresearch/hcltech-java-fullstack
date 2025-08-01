package com.cetpa.repositories;

import com.cetpa.models.Account;

public interface AccountRepository 
{
	void persistAccount(Account account);
	int getAccountNoByUserId(String userid);
	int getAmount(Object attribute);
	void updateAmount(int amount, int accountno);
}
