package com.hcl.payments.repository;

public class CurrentAccount implements MaintenanceCharge{

	@Override
	public float maintenanceCharge(float noOfyear) {
		
		return ((100*noOfyear)+200);
	}

}
