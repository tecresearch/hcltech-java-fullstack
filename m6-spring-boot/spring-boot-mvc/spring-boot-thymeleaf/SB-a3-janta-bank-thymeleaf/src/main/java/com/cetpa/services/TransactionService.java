package com.cetpa.services;

import com.cetpa.models.TransactionInfo;

public interface TransactionService 
{
	TransactionInfo saveWthdrawTransaction(int saccountno, int amount);
	TransactionInfo saveDepositTransaction(int accountno, int amount);
	TransactionInfo saveTransferTransaction(int saccountno, int amount, int raccountno);
}
