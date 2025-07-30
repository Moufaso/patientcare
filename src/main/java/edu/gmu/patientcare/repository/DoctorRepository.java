package edu.gmu.patientcare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.gmu.patientcare.model.Doctor;
import java.util.List;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    List<Doctor> findByName(String name);
}
