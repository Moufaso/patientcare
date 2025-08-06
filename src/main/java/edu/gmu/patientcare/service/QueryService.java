package edu.gmu.patientcare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.gmu.patientcare.model.Appointment;
import edu.gmu.patientcare.model.Doctor;
import edu.gmu.patientcare.model.Lab;
import edu.gmu.patientcare.model.LabResult;
import edu.gmu.patientcare.model.Nurse;
import edu.gmu.patientcare.model.Patient;
import edu.gmu.patientcare.model.Prescription;
import edu.gmu.patientcare.repository.AppointmentRepository;
import edu.gmu.patientcare.repository.DoctorRepository;
import edu.gmu.patientcare.repository.LabRepository;
import edu.gmu.patientcare.repository.LabResultRepository;
import edu.gmu.patientcare.repository.NurseRepository;

import edu.gmu.patientcare.repository.PatientRepository;
import edu.gmu.patientcare.repository.PrescriptionRepository;



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
	@Autowired
	NurseRepository nurseRepo;


	public Patient getPatientById(int id) {
		return patientRepo.findById(id).orElse(null);
	}

	public Nurse getNurseById(int id) {
		return nurseRepo.findById(id).orElse(null);
	}
	
    public Optional<String> getDoctorNameByBusinessId(int id) {
        return doctorRepo.findById(id).map(Doctor::getName);

    }


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
	
    public Optional<Appointment> getAppointmentByBusinessId(int id) {
        return appointmentRepo.findByBusinessId(id);
    }
    
    public Optional<Lab> getLabById(int id) {
        return labRepo.findByIdInt(id); // your custom finder on business field "id"
    }
    
    ///////////////////////////////////////////
    
    public List<Map<String, Object>> getLabCountsByNurse() {
        return labRepo.countLabsByNurse();
    }

    public List<Map<String, Object>> getAppointmentCountsByDepartment() {
        return appointmentRepo.countAppointmentsByDepartment();
    }

    
    //test
//    public void testLabQueryOutput() {
//        List<Object[]> results = labRepo.countLabsByNurse();
//
//        if (results == null || results.isEmpty()) {
//            System.out.println("No results returned from query.");
//            return;
//        }
//
//        for (Object[] row : results) {
//            System.out.println("Row length: " + row.length);
//            for (int i = 0; i < row.length; i++) {
//                System.out.println("Row[" + i + "]: " + row[i]);
//            }
//        }
//    }

    


}