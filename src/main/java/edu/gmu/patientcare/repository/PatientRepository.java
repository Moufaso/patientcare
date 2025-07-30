package edu.gmu.patientcare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.gmu.patientcare.model.Patient;
import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String>{
    List<Patient> findByName(String name);
}
