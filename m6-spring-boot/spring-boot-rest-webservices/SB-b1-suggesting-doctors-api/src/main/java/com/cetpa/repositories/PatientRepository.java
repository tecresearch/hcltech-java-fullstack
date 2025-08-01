package com.cetpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cetpa.entities.*;

public interface PatientRepository extends JpaRepository<Patient,Integer> 
{
}
