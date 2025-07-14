package com.hcl.payments.repository;

import java.util.List;

import com.hcl.payments.model.Account;

public interface PaymentRepository {
   public boolean saveAccount(Account account);
   public boolean savePayment(int ammount, int senderAccountNo,int recieverAccountNo, String ifscCode);
   public boolean savePayment(int ammount, String senderUpiId,String recieverUpiId);
   public Account findAccountByAccountNo(int accountNo);
   public Account findAccountByUpiId(String upiId);
   public int getBalanceByAccountNo(int accountNo);
   public List<Account> getAccounts();
   public boolean depositMoney(int accountNo, int amount);
   public boolean withdrawMoney(int wAccountNo, int wAmount);
}
