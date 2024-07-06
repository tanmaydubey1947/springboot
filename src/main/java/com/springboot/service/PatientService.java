package com.springboot.service;


import com.springboot.entity.Patient;
import com.springboot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;


    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
