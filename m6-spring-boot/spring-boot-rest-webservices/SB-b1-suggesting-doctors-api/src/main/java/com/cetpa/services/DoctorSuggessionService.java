package com.cetpa.services;

import java.util.List;

import com.cetpa.entities.Doctor;

public interface DoctorSuggessionService 
{
	List<Doctor> getDoctorList(int pid);
}
