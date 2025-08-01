package com.cetpa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.TransactionInfo;
import com.cetpa.repositories.TransactionRepository;
import com.cetpa.services.TransactionService;
import com.cetpa.utility.DateTimeUtility;

@Service
public class TransactionServiceImpl implements TransactionService 
{
	@Autowired private TransactionRepository transactionRepository;
	@Autowired private DateTimeUtility dateTimeUtility; 

	public TransactionInfo saveWthdrawTransaction(int accountno, int amount) 
	{
		return saveTransaction(accountno, amount,"Debit",accountno);
	}
	public TransactionInfo saveDepositTransaction(int accountno, int amount) 
	{
		return saveTransaction(accountno, amount,"Credit",accountno);
	}
	public TransactionInfo saveTransferTransaction(int saccountno, int amount, int raccountno) 
	{
		saveTransaction(saccountno,amount,"Credit", raccountno);
		return saveTransaction(saccountno,amount,"Debit", raccountno);
	}
	private TransactionInfo saveTransaction(int saccountno,int amount,String type,int raccountno)
	{
		TransactionInfo transactionInfo=new TransactionInfo();
		transactionInfo.setFromaccount(saccountno);
		transactionInfo.setAmount(amount);
		transactionInfo.setType(type);
		transactionInfo.setDate(dateTimeUtility.getCurrentDate());
		transactionInfo.setTime(dateTimeUtility.getCurrentTime());
		transactionInfo.setToaccount(raccountno);
		transactionRepository.save(transactionInfo);
		return transactionInfo;
	}
}
