package com.cetpa.models;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionInfo 
{
	@Id
	@GeneratedValue(generator = "t_sequence")
	@SequenceGenerator(name = "t_sequence",initialValue = 123456,allocationSize = 1)
	private int tid;
	private int fromaccount;
	private int amount;
	private String type;
	private String date;
	private String time;
	private int toaccount;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getFromaccount() {
		return fromaccount;
	}
	public void setFromaccount(int fromaccount) {
		this.fromaccount = fromaccount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getToaccount() {
		return toaccount;
	}
	public void setToaccount(int toaccount) {
		this.toaccount = toaccount;
	}
}
