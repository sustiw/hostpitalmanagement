package com.st.yt.hospitalManagement;


import com.st.yt.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.st.yt.hospitalManagement.entity.Patient;
import com.st.yt.hospitalManagement.repository.PatientRepository;
import com.st.yt.hospitalManagement.service.PatientService;
import com.st.yt.hospitalManagement.type.BloodGroupType;
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

//        List<Patient> patentList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1985, 05, 15), "jane.smith@email.com");
//        System.out.println("pateint with dob or email ---" + patentList);
//
//        patentList.stream().forEach(patient -> System.out.println(patient.getName()));


        //    List<Patient> patentList = patientRepository.findByNameContaining("Jo");

        // System.out.println("pateint with dob or email ---" + patentList);


        //   List<Patient> patentList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
        //  System.out.println("pateint with bloodgroup ---" + patentList);
        // patentList.stream().forEach(patient -> System.out.println(patient.getName()));


//        List<Patient> patentList = patientRepository.findByBornAfterDate(LocalDate.of(1999,1,01));
//        System.out.println("pateint  after birthdate ---" + patentList);
//        patentList.stream().forEach(patient -> System.out.println(patient.getName()));
//
//        List<Object[]> groupList = patientRepository.countEachBloodGroupType();
//        System.out.println("pateint  group by blood group ---" + groupList);
//
//        groupList.forEach(object -> System.out.println(object[0] + "--" + object[1]));

        List<BloodGroupCountResponseEntity> groupList = patientRepository.countEachBloodGroupType();
        System.out.println("pateint  group by blood group ---" + groupList);
        groupList.forEach(bloodGroupCountResponseEntity -> System.out.println(bloodGroupCountResponseEntity.getBloodGroup() + " " + bloodGroupCountResponseEntity.getCount()));


//        List<Patient> allPatientList= patientRepository.findAllPatient();
//        allPatientList.stream().forEach(patient -> System.out.println(patient));


//       int rowUpdate= patientRepository.updatePatentNameWithId("Sushil Tiwari",1L);
//        System.out.println("updated rows: "+rowUpdate);
    }
}
