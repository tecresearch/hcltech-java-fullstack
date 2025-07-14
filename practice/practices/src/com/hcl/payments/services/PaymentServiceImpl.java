package com.hcl.payments.services;

import java.util.List;

import com.hcl.payments.model.Account;
import com.hcl.payments.repository.PaymentRepository;
import com.hcl.payments.repository.PaymentRepositoryImpl;
import com.hcl.payments.utils.AccountNoGenerator;

public class PaymentServiceImpl implements PaymentService{
    
	private final PaymentRepository paymentRepository=new PaymentRepositoryImpl();
	

	@Override
	public boolean createAccount(String accountHolder,String bankName,String ifscCode) {
		Account account=new Account();
		
		account.setAccountNumber(AccountNoGenerator.generateAccountNo());		
		account.setHolderName(accountHolder);
		account.setBankName(bankName);
		account.setIfscCode(ifscCode);
		account.setUpiId(null);
		account.setUpiStatus(false);
		account.setBalance(0);
	
		System.out.println("Account creating..........");
		boolean status=paymentRepository.saveAccount(account);
		return status;
	}
	@Override
	public Account getAccountByAccountNo(int accountNo) {
		System.out.println("Searching account via AccountNO.........");
		Account account=paymentRepository.findAccountByAccountNo(accountNo);
		
		return account;
	}

	@Override
	public Account getAccountByUpiId(String upiId) {
		System.out.println("Searching account via UPI.........");
		Account account=paymentRepository.findAccountByUpiId(upiId);
		
		return account;
	}

	@Override
	public List<Account> accountList() {
		return paymentRepository.getAccounts();
	}
	@Override
	public boolean doPayment(int ammount,int senderAccountNo,int recieverAccountNo, String ifscCode) {
		System.out.println("NEFT Payment initiated.......");
		boolean status=paymentRepository.savePayment(ammount,senderAccountNo,recieverAccountNo,ifscCode);
		
		return status;
	}

	@Override
	public boolean doPayment(int ammount,String senderUpiId,String recieverUpiId) {
		System.out.println("UPI Payment initiated.......");
		boolean status=paymentRepository.savePayment(ammount,senderUpiId,recieverUpiId);
		
		return status;
	}


	@Override
	public int checkBalance(int accountNo) {
		System.out.println("Balance fetching........");
		paymentRepository.getBalanceByAccountNo(accountNo);
		return 0;
	}
	@Override
	public boolean depositMoney(int daccountNo, int damount) {
		return paymentRepository.depositMoney(daccountNo, damount);
		
		
	}
	@Override
	public boolean withdrawMoney(int wAccountNo, int wAmount) {
		return paymentRepository.withdrawMoney(wAccountNo, wAmount);
		
		
	}


	
	

}
