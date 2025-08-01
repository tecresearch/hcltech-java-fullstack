package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.Patient;
import com.cetpa.services.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("suggesting-doctor-api/patient")
public class PatientController 
{
	@Autowired private PatientService patientService;
	
	@PostMapping("add")
	public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient)
	{
		patientService.savePatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);
	}
}
