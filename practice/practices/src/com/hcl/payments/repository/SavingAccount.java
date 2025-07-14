package com.hcl.payments.repository;

public class SavingAccount implements MaintenanceCharge {

	@Override
	public float maintenanceCharge(float noOfyear) {
		
		return ((50*noOfyear)+50);
	}

}
