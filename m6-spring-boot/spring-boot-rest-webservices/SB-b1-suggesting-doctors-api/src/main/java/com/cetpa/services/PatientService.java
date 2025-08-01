package com.cetpa.services;

import com.cetpa.entities.Patient;

import jakarta.validation.Valid;

public interface PatientService 
{
	void savePatient(@Valid Patient patient);
}
