package com.st.yt.hospitalManagement.service;

import com.st.yt.hospitalManagement.entity.Appointment;
import com.st.yt.hospitalManagement.entity.Doctor;
import com.st.yt.hospitalManagement.entity.Patient;
import com.st.yt.hospitalManagement.repository.AppointmentRepository;
import com.st.yt.hospitalManagement.repository.DoctorRepository;
import com.st.yt.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {


    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {

        Doctor doctor = doctorRepository.findById((doctorId)).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if (appointment.getId() != null) throw new IllegalArgumentException("Apoitment should not have null");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);
        appointmentRepository.save(appointment);
        return appointment;
    }

}

