package com.hcl.payments.repository;

import java.util.ArrayList;
import java.util.List;

import com.hcl.payments.model.Account;
import com.hcl.payments.model.Transactions;

public class PaymentRepositoryImpl implements PaymentRepository{
     List<Account> accounts=new ArrayList<Account>();
     List<Transactions> transactions=new ArrayList<>();
     
	@Override
	public boolean saveAccount(Account account) {
		accounts.add(account);
		System.out.println("Account created successfully and Account No:"+account.getAccountNumber());
		return true;
	}
	@Override
	public Account findAccountByAccountNo(int accountNo) {
		for(Account account:accounts) {
			if(account.getAccountNumber()==accountNo) {
				System.out.println("Found account via AccountNO: "+accountNo);
				return account;
			}
		}
		
		return null;
	}
	@Override
	public Account findAccountByUpiId(String upiId) {
		for(Account account:accounts) {
			if(account.getUpiId()==upiId) {
				System.out.println("Found account via AccountNO: "+upiId);
				return account;
			}
		}
		
		return null;
		
		
	}

	@Override
	public List<Account> getAccounts() {
		return accounts;
	}
	
	@Override
	public boolean depositMoney(int accountNo, int amount) {
	    for (Account account : accounts) {
	        if (account.getAccountNumber() == accountNo) {
	            int newBalance = account.getBalance() + amount;
	            account.setBalance(newBalance);
	            System.out.println("Deposit successful. New balance: " + newBalance);
	            return true;
	        }
	    }
	    System.out.println("Account not found. Deposit failed.");
	    return false;
	}


	@Override
	public boolean savePayment(int amount, int senderAccountNo, int receiverAccountNo, String ifscCode) {
	    Account senderAccount = null;
	    Account receiverAccount = null;

	    // Find sender and receiver accounts
	    for (Account account : accounts) {
	        if (account.getAccountNumber() == senderAccountNo) {
	            senderAccount = account;
	        }
	        if (account.getAccountNumber() == receiverAccountNo && account.getIfscCode().equals(ifscCode)) {
	            receiverAccount = account;
	        }
	    }

	    // Validate both accounts
	    if (senderAccount == null) {
	        System.out.println("Sender account not found.");
	        return false;
	    }
	    if (receiverAccount == null) {
	        System.out.println("Receiver account not found or IFSC code mismatch.");
	        return false;
	    }

	    // Check if sender has sufficient balance
	    if (senderAccount.getBalance() < amount) {
	        System.out.println("Insufficient balance in sender's account.");
	        return false;
	    }

	    // Perform transaction
	    senderAccount.setBalance(senderAccount.getBalance() - amount);
	    receiverAccount.setBalance(receiverAccount.getBalance() + amount);

	    System.out.println("NEFT Payment successfully completed.");
	    return true;
	}

	@Override
	public boolean savePayment(int amount, String senderUpiId, String receiverUpiId) {
	    Account senderAccount = null;
	    Account receiverAccount = null;

	    // Find sender and receiver accounts
	    for (Account account : accounts) {
	        if (account.getUpiId().equals(senderUpiId)) {
	            senderAccount = account;
	        }
	        if (account.getUpiId().equals(receiverUpiId)) {
	            receiverAccount = account;
	        }
	    }

	    // Validate both accounts
	    if (senderAccount == null) {
	        System.out.println("Sender UPI ID not found.");
	        return false;
	    }
	    if (receiverAccount == null) {
	        System.out.println("Receiver UPI ID not found.");
	        return false;
	    }

	    // Check if sender has sufficient balance
	    if (senderAccount.getBalance() < amount) {
	        System.out.println("Insufficient balance in sender's account.");
	        return false;
	    }

	    // Perform transaction
	    senderAccount.setBalance(senderAccount.getBalance() - amount);
	    receiverAccount.setBalance(receiverAccount.getBalance() + amount);

	    System.out.println("UPI Payment successfully completed.");
	    return true;
	}



	@Override
	public int getBalanceByAccountNo(int accountNo) {
	    for (Account account : accounts) {
	        if (account.getAccountNumber() == accountNo) {
	            return account.getBalance();
	        }
	    }
	    System.out.println("Account not found.");
	    return 0;
	}
	@Override
	public boolean withdrawMoney(int wAccountNo, int wAmount) {
		for (Account account : accounts) {
	        if (account.getAccountNumber() == wAccountNo) {
	            int newBalance = account.getBalance() - wAmount;
	            account.setBalance(newBalance);
	            System.out.println("Withdraw successful. New balance: " + newBalance);
	            return true;
	        }
	    }
	    System.out.println("Account not found. Deposit failed.");
	    return false;
		 
	}

	 

}
