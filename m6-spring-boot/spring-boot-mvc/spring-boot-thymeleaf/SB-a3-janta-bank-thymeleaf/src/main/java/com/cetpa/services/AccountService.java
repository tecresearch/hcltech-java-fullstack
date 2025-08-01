package com.cetpa.services;

import com.cetpa.models.TransactionInfo;

public interface AccountService 
{
	TransactionInfo depositMoney(int amount, int accountno);
	TransactionInfo withdrawMoney(int amount, int accountno);
	int getAccountBalance(int accountno);
	String getAccountHolder(int accountno);
	TransactionInfo transferMoney(int amount, int accountno, int raccountno);
}
