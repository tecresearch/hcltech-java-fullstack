package com.cetpa.services;

import com.cetpa.models.TransactionInfo;

public interface AccountService 
{
	TransactionInfo depositMoney(int amount, int accountno);
}
