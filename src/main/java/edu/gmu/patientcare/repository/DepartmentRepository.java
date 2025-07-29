package edu.gmu.patientcare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.gmu.patientcare.model.Department;

public interface DepartmentRepository extends MongoRepository<Department, String> {
    
}
