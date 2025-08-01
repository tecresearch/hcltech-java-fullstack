package com.cetpa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cetpa.models.TransactionInfo;
import com.cetpa.repositories.AccountRepository;
import com.cetpa.services.AccountService;
import com.cetpa.services.TransactionService;



@Service
public class AccountServiceImpl implements AccountService
{
	@Autowired private AccountRepository accountRepository;
	@Autowired private TransactionService transactionService;
	
	public TransactionInfo depositMoney(int amount, int accountno) 
	{
		//Update amount value into Account object
		accountRepository.updateAmount(amount,accountno);
		return transactionService.saveDepositTransaction(accountno,amount);
	}
	public TransactionInfo withdrawMoney(int amount, int accountno) 
	{
		accountRepository.updateAmount(-amount,accountno);
		return transactionService.saveWthdrawTransaction(accountno,amount);
	}
	public TransactionInfo transferMoney(int amount, int accountno, int raccountno) 
	{
		//Updating sender amount
		accountRepository.updateAmount(-amount,accountno);
		//Updating receiver amount
		accountRepository.updateAmount(amount,raccountno);
		return transactionService.saveTransferTransaction(accountno,amount,raccountno);
	}
	public int getAccountBalance(int accountno) 
	{
		return accountRepository.getAmount(accountno);
	}
	public String getAccountHolder(int accountno) 
	{
		String name=accountRepository.getNameByAccountno(accountno);
		return name;
	}
}
