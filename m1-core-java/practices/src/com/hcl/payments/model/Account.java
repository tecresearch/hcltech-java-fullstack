package com.hcl.payments.model;

public class Account {
	private int accountNumber;
	private String holderName;
	private String bankName;
	private String ifscCode;
	private String upiId;
	private boolean upiStatus;
	private int balance;
	
	public Account() {
		
	}

	public Account(int accountNumber, String holderName, String bankName, String ifscCode, String upiId,
			boolean upiStatus, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.upiId = upiId;
		this.upiStatus = upiStatus;
		this.balance = balance;
	}
	


	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public boolean isUpiStatus() {
		return upiStatus;
	}

	public void setUpiStatus(boolean upiStatus) {
		this.upiStatus = upiStatus;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", holderName=" + holderName + ", bankName=" + bankName
				+ ", ifscCode=" + ifscCode + ", upiId=" + upiId + ", upiStatus=" + upiStatus + ", balance=" + balance
				+ "]";
	}
	
	
	
	
	
}
