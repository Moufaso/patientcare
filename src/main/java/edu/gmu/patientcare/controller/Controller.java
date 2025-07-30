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
}
