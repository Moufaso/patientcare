package edu.gmu.patientcare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.gmu.patientcare.model.Doctor;

public interface DoctorRepository extends MongoRepository<Doctor, String> {

}
