package edu.gmu.patientcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.gmu.patientcare.model.*;
import edu.gmu.patientcare.repository.AppointmentRepository;
import edu.gmu.patientcare.repository.PatientRepository;
import edu.gmu.patientcare.repository.PrescriptionRepository;

@Service
public class QueryService {
    @Autowired
    PatientRepository patientRepo;
    @Autowired
    AppointmentRepository appointmentRepo;
    @Autowired
    PrescriptionRepository prescriptionRepo;

    public List<Prescription> findPrescription(String name) {
        List<Patient> patients = patientRepo.findByName(name);
        List<Appointment> appointments = new ArrayList<>();
        List<Prescription> prescriptions = new ArrayList<>();
        for(Patient patient : patients)
            appointments.addAll(appointmentRepo.findByPatientId(patient.getId()));
        for(Appointment appointment : appointments)
            prescriptions.addAll(prescriptionRepo.findByAppointmentId(appointment.getId()));
            
        return prescriptions;
    }
}
