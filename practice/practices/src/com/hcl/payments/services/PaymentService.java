package com.hcl.payments.services;

import java.util.List;

import com.hcl.payments.model.Account;

public interface PaymentService {
	public boolean createAccount(String accountHolder, String bankName, String ifscCode);
	public boolean doPayment(int ammount,int senderAccountNo,int recieverAccountNo,String ifscCode);
	public boolean doPayment(int ammount,String senderUpiId,String recieverUpiId);
	public int checkBalance(int accountNo);
	public Account getAccountByAccountNo(int accountNo);
	public List<Account> accountList();
	public Account getAccountByUpiId(String upiId);
	public boolean depositMoney(int daccountNo, int damount);
	public boolean withdrawMoney(int wAccountNo, int wAmount);
}
