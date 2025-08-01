package com.cetpa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.TransactionInfo;
import com.cetpa.repositories.AccountRepository;
import com.cetpa.repositories.TransactionRepository;
import com.cetpa.services.AccountService;
import com.cetpa.utility.DateTimeUtility;


@Service
public class AccountServiceImpl implements AccountService
{
	@Autowired private AccountRepository accountRepository;
	@Autowired private DateTimeUtility dateTimeUtility;
	@Autowired private TransactionRepository transactionRepository;
	
	public TransactionInfo depositMoney(int amount, int accountno) 
	{
		//Update amount value into Account object
		accountRepository.updateAmount(amount,accountno);
		TransactionInfo transactionInfo=new TransactionInfo();
		//Save transaction details into TranSactionInfo object
		transactionInfo.setFromaccount(accountno);
		transactionInfo.setAmount(amount);
		transactionInfo.setType("Credit");
		transactionInfo.setDate(dateTimeUtility.getCurrentDate());
		transactionInfo.setTime(dateTimeUtility.getCurrentTime());
		transactionInfo.setToaccount(accountno);
		transactionRepository.saveTransaction(transactionInfo);
		return transactionInfo;
	}
}
