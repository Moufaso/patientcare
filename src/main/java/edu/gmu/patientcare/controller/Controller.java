package edu.gmu.patientcare.controller;

import edu.gmu.patientcare.model.*;
import edu.gmu.patientcare.service.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
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
    
    
    
    
    
    
}
