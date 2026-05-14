package com.st.yt.hospitalManagement.service;

import com.st.yt.hospitalManagement.entity.Patient;
import com.st.yt.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id) {

        Patient patient1 = patientRepository.findById(id).orElseThrow();
        Patient patient2 = patientRepository.findById(id).orElseThrow();
        return patient1;
    }
}
