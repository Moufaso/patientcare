package edu.gmu.patientcare.controller;

//import edu.gmu.patientcare.model.*;
//import edu.gmu.patientcare.service.*;
import org.springframework.web.bind.annotation.RestController;

import edu.gmu.patientcare.model.Appointment;
import edu.gmu.patientcare.model.Lab;
import edu.gmu.patientcare.model.LabResult;
import edu.gmu.patientcare.model.Nurse;
import edu.gmu.patientcare.model.Patient;
import edu.gmu.patientcare.model.Prescription;
import edu.gmu.patientcare.service.QueryService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class Controller {
    
    @Autowired
    private QueryService query;

    @GetMapping("/prescription/{name}")
    public ResponseEntity<?> getPrescriptionForPatient(@PathVariable("name") String name) {
        List<Prescription> prescriptions = query.findPrescriptionForPatient(name);
        
        return new ResponseEntity<List<Prescription>>(prescriptions, HttpStatus.OK);
    }

    @GetMapping("/result/{name}")
    public ResponseEntity<?> getLabReslutForPatient(@PathVariable("name") String name) {
        List<LabResult> labResults = query.findResultForPatient(name);
        
        return new ResponseEntity<List<LabResult>>(labResults, HttpStatus.OK);
    }
    
    /*
     * Appointments for a department
     * GET /appointments/department/{deptName}
     * Example: /appointments/department/Cardiology
     */
    
    @GetMapping("/appointments/department/{deptName}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDepartment(@PathVariable String deptName) {
        List<Appointment> list = query.getAppointmentsByDepartment(deptName);
        return ResponseEntity.ok(list);
    }
    

    /* 
     * Labs for a department
     * GET /labs/department/{deptName}
     * Example: /labs/department/Emergency%20Medicine
    */
    @GetMapping("/labs/department/{deptName}")
    public ResponseEntity<List<Lab>> getLabsByDepartment(@PathVariable String deptName) {
        List<Lab> list = query.getLabsByDepartment(deptName);
        return ResponseEntity.ok(list);
    }
    
    /********************************************************************************************/
    
    
    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id) {
        Optional<Patient> patient = Optional.ofNullable(query.getPatientById(id));
        return patient.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    
    @GetMapping("/nurses/{id}")
    public ResponseEntity<Nurse> getNurseById(@PathVariable int id) {
        Optional<Nurse> nurse = Optional.ofNullable(query.getNurseById(id));
        return nurse.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/doctors/{id}")
    public ResponseEntity<?> getDoctorName(@PathVariable("id") int id) {
        Optional<String> maybeName = query.getDoctorNameByBusinessId(id);
        if (maybeName.isPresent()) {
            return ResponseEntity.ok(Map.of("name", maybeName.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Doctor not found"));
    }
    

    @GetMapping("/appointments/{id}")
    public ResponseEntity<?> getAppointmentById(@PathVariable("id") int id) {
      Optional<Appointment> maybe = query.getAppointmentByBusinessId(id);
      if (maybe.isPresent()) {
        return ResponseEntity.ok(maybe.get());
      }
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(Map.of("error", "Appointment not found"));
    }
    
    @GetMapping("/labs/{id}")
    public ResponseEntity<Lab> getLabById(@PathVariable int id) {
        return query.getLabById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    /////////////////////////////////////////////
    @GetMapping("/labs/count-by-nurse")
    public ResponseEntity<?> getNurseLabCounts() {
        return ResponseEntity.ok(query.getLabCountsByNurse());
    }

    @GetMapping("/appointments/count-by-department")
    public ResponseEntity<List<Map<String, Object>>> getAppointmentCountsByDepartment() {
        return ResponseEntity.ok(query.getAppointmentCountsByDepartment());
    }

}
