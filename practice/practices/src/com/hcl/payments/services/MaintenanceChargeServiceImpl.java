package com.hcl.payments.services;

import com.hcl.payments.model.Account;
import com.hcl.payments.repository.CurrentAccount;
import com.hcl.payments.repository.MaintenanceCharge;
import com.hcl.payments.repository.SavingAccount;

public class MaintenanceChargeServiceImpl implements MaintenanceChargeService{
	MaintenanceCharge saving=new SavingAccount();
	MaintenanceCharge current=new CurrentAccount();
	@Override
	public void applyMaintenanceCharge(int accountNo, String customerName, int balance,float noOfYear,String type) {
		
		Account accountAccount=new  Account( accountNo, customerName, balance, noOfYear, type);
		System.out.println("Account Holder Name "+accountAccount.getHolderName());
		System.out.println("Account No "+accountAccount.getAccountNumber());
		System.out.println("Account Balance "+accountAccount.getBalance());

		if(type.equals("saving")){
			
			System.out.println("Maintenance charge for saving account "+saving.maintenanceCharge(noOfYear));
			}
		else if(type.equals("current")){
			
			System.out.println("Maintenance charge for current account "+current.maintenanceCharge(noOfYear));
		}
		
		
	}

	
	
	

}
