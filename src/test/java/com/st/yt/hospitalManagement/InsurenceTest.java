package com.st.yt.hospitalManagement;

import com.st.yt.hospitalManagement.entity.Appointment;
import com.st.yt.hospitalManagement.entity.Insurance;
import com.st.yt.hospitalManagement.entity.Patient;
import com.st.yt.hospitalManagement.service.AppointmentService;
import com.st.yt.hospitalManagement.service.InsurenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsurenceTest {

    @Autowired
    private InsurenceService insurenceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance() {

        Insurance insurance = Insurance.builder()
                .policyNumber("HFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2031, 9, 23))
                .build();

        Patient patient = insurenceService.assignInsurerceToPatient(insurance, 1L);
        System.out.println("patient---" + patient);
    }


    @Test
    public void testCreateAppointment() {

        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 9, 23, 14, 30))
                .reason("cancer")
                .build();

        var newAppoinntment = appointmentService.createNewAppointment(appointment,1L,1L);
        System.out.println(newAppoinntment );
    }
}
