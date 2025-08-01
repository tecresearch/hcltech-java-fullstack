package com.cetpa.repositories;

import java.util.List;

import com.cetpa.models.TransactionInfo;

public interface TransactionRepository 
{
	void saveTransaction(TransactionInfo transactionInfo);
	List<TransactionInfo> getList(int accountno);
}
