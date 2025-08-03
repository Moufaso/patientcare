package edu.gmu.patientcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.gmu.patientcare.model.*;
import edu.gmu.patientcare.repository.*;

@Service
public class QueryService {
    @Autowired
    PatientRepository patientRepo;
    @Autowired
    DoctorRepository doctorRepo;
    @Autowired
    AppointmentRepository appointmentRepo;
    @Autowired
    LabRepository labRepo;
    @Autowired
    PrescriptionRepository prescriptionRepo;
    @Autowired
    LabResultRepository labResultRepo;

    /*
     * Return list of prescriptions based on patient name
     */
    public List<Prescription> findPrescriptionForPatient(String name) {
        List<Patient> patients = patientRepo.findByName(name);
        List<Appointment> appointments = new ArrayList<>();
        List<Prescription> prescriptions = new ArrayList<>();
        for(Patient patient : patients)
            appointments.addAll(appointmentRepo.findByPatientId(patient.getId()));
        for(Appointment appointment : appointments)
            prescriptions.addAll(prescriptionRepo.findByAppointmentId(appointment.getId()));
            
        return prescriptions;
    }

    /*
     * Return list of lab results based on patient name
     */
    public List<LabResult> findResultForPatient(String name) {
        List<Patient> patients = patientRepo.findByName(name);
        List<Lab> labs = new ArrayList<>();
        List<LabResult> labResults = new ArrayList<>();
        for(Patient patient: patients)
            labs.addAll(labRepo.findByPatientId(patient.getId()));
        for(Lab lab: labs)
            labResults.addAll(labResultRepo.findByLabId(lab.getId()));

        return labResults;
    }
    
    
    public List<Appointment> getAppointmentsByDepartment(String deptName) {
        return appointmentRepo.findAppointmentsByDepartment(deptName);
    }

    public List<Lab> getLabsByDepartment(String deptName) {
        return labRepo.findLabsByDepartment(deptName);
    }
    
}
