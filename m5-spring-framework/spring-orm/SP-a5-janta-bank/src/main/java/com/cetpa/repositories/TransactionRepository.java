package com.cetpa.repositories;

import com.cetpa.models.TransactionInfo;

public interface TransactionRepository 
{
	void saveTransaction(TransactionInfo transactionInfo);
}
