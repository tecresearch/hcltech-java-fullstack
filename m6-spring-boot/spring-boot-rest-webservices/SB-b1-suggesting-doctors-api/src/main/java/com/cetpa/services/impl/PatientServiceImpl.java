package com.cetpa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Patient;
import com.cetpa.repositories.PatientRepository;
import com.cetpa.services.PatientService;

import jakarta.validation.Valid;

@Service
public class PatientServiceImpl implements PatientService 
{
	@Autowired private PatientRepository patientRepository;

	public void savePatient(@Valid Patient patient) 
	{
		patientRepository.save(patient);
	}
}
