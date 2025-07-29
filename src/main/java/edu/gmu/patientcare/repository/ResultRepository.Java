package edu.gmu.patientcare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.gmu.patientcare.model.Result;

public interface ResultRepository extends MongoRepository<Result, String> {
    
}