package com.cetpa.services.impl;

import org.springframework.stereotype.Service;

import com.cetpa.entities.Doctor;
import com.cetpa.exception.DoctorNotFoundException;
import com.cetpa.repositories.DoctorRepository;
import com.cetpa.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService 
{
	private DoctorRepository doctorRepository;
	public DoctorServiceImpl(DoctorRepository doctorRepository)
	{
		this.doctorRepository=doctorRepository;
	}
	public void persistDoctor(Doctor doctor) 
	{
		doctorRepository.save(doctor);
	}
	public Doctor getDoctor(int did) 
	{
		//Doctor doctor=doctorRepository.findById(did).orElseThrow(()->new DoctorNotFoundException("Doctor with id "+did+" does not exist"));
		Doctor doctor=doctorRepository.findById(did).orElse(null);
		if(doctor==null)
				throw new DoctorNotFoundException("Doctor with id "+did+" does not exist");
		return doctor;
	}
}
