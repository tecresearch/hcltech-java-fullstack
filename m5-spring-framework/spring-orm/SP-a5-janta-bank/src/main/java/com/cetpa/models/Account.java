package com.cetpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Account 
{
	@Id
	@GeneratedValue(generator = "account_seq")
	@SequenceGenerator(name = "account_seq",initialValue = 139200010,allocationSize = 1)
	private int accountno;
	private String userid;
	private int amount;
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
