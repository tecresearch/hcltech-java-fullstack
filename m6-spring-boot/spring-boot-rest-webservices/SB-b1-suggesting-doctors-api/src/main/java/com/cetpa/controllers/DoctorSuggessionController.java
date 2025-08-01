package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.Doctor;
import com.cetpa.services.DoctorSuggessionService;

@RestController
@RequestMapping("suggesting-doctor-api")
public class DoctorSuggessionController 
{
	@Autowired private DoctorSuggessionService doctorSuggessionService;
		
	@GetMapping("doctor-list")
	public ResponseEntity<List<Doctor>> findDoctorListforPatient(@RequestParam int pid)
	{
		List<Doctor> doctors=doctorSuggessionService.getDoctorList(pid);
		return ResponseEntity.ok(doctors);
	}
}
