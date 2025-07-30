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

    @GetMapping("/patient/{name}")
    public ResponseEntity<?> getPrescriptionsByPatient(@PathVariable("name") String name) {
        List<Prescription> prescriptions = query.findPrescription(name);
        
        return new ResponseEntity<List<Prescription>>(prescriptions, HttpStatus.OK);
    }
}
