package com.st.yt.hospitalManagement.service;

import com.st.yt.hospitalManagement.entity.Insurance;
import com.st.yt.hospitalManagement.entity.Patient;
import com.st.yt.hospitalManagement.repository.InsuranceRepository;
import com.st.yt.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsurenceService {


    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsurerceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("patient not found" + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);

        return patient;
    }
}
