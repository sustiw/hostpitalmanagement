package com.st.yt.hospitalManagement;


import com.st.yt.hospitalManagement.entity.Patient;
import com.st.yt.hospitalManagement.repository.PatientRepository;
import com.st.yt.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testAllPatientRepo() {
        List<Patient> patientList = patientRepository.findAll();

        System.out.println("patientList---" + patientList);

    }

    @Test
    public void testTransactionMethod() {

        // Patient pateint= patientService.getPatientById(1L);
        // System.out.println("pateint with id 1---"+patient);

        // Patient patient= patientRepository.findByName("John Doe");
        //System.out.println("pateint with name ---"+patient);

        List<Patient> patentList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1985, 05, 15), "jane.smith@email.com");
        System.out.println("pateint with dob or email ---" + patentList);

        patentList.stream().forEach(patient -> System.out.println(patient.getName()));
    }
}
