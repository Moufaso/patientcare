package edu.gmu.patientcare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.gmu.patientcare.model.Doctor;
import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    List<Doctor> findByName(String name);
    Optional<Doctor> findById(int id);
}
