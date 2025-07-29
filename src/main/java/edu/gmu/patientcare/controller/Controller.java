package edu.gmu.patientcare.controller;

import edu.gmu.patientcare.model.*;
import edu.gmu.patientcare.service.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class Controller {
    
    @Autowired
    private QueryService query;

    @GetMapping
    public List<Prescription> getAllPatients() {
        return query.findPrescription("Sarah Johnson");
    }
}
