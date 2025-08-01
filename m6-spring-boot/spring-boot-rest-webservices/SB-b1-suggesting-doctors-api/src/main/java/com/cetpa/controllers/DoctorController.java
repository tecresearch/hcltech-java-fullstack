package com.cetpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.Doctor;
import com.cetpa.services.DoctorService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("suggesting-doctor-api/doctor")
public class DoctorController 
{
	@Autowired private DoctorService doctorService;
	
	@Operation(summary = "Create a new doctor", description = "Adds a doctor to the system")
	@PostMapping("add")
	public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor)
	{
		System.out.println("Add doctor handler invoked...");
		doctorService.persistDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
	}
	@Operation(summary = "Get details of a doctor", description = "System provide doctor details by id")
	@GetMapping("search/{did}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable int did)
	{
		Doctor doctor=doctorService.getDoctor(did);
		return ResponseEntity.ok(doctor);
	}
}
