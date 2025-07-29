package edu.gmu.patientcare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.gmu.patientcare.model.Lab;

public interface LabRepository extends MongoRepository<Lab, String> {
    
}
