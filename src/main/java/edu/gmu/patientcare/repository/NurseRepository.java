package edu.gmu.patientcare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.gmu.patientcare.model.Nurse;

public interface NurseRepository extends MongoRepository<Nurse, String>  {
    
}
