package com.cetpa.services;

import com.cetpa.entities.Doctor;

public interface DoctorService 
{
	void persistDoctor(Doctor doctor);
	Doctor getDoctor(int did);
}
