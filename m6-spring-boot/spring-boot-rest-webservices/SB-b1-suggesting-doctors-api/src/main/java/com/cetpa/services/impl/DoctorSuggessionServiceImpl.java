package com.cetpa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Doctor;
import com.cetpa.entities.Patient;
import com.cetpa.exception.PatientNotFoundException;
import com.cetpa.repositories.DoctorRepository;
import com.cetpa.repositories.PatientRepository;
import com.cetpa.services.DoctorSuggessionService;
import com.cetpa.utility.Symptom;

@Service
public class DoctorSuggessionServiceImpl implements DoctorSuggessionService
{
	@Autowired private PatientRepository patientRepository;
	@Autowired private DoctorRepository doctorRepository;
	
	public List<Doctor> getDoctorList(int pid) 
	{
		Patient patient=patientRepository.findById(pid).orElse(null);
		if(patient==null)
			throw new PatientNotFoundException("Patient with id "+pid+" does not exist");
		String city=patient.getCity();
		if(!(city.equals("Noida") || city.equals("Delhi") ||city.equals("Faridabad")))
			throw new RuntimeException("We are still waiting to expand to your location");
		String symptom=patient.getSymptom();
		String speciality=Symptom.map.get(symptom);
		List<Doctor> doctorList=doctorRepository.findDoctorsByCityAndSpeciality(city,speciality);
		if(doctorList.isEmpty())
			throw new RuntimeException("There isn’t any doctor present at your location for your symptom");
		return doctorList;
	}
}
