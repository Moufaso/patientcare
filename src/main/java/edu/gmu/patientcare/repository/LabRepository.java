package edu.gmu.patientcare.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import edu.gmu.patientcare.model.Lab;

public interface LabRepository extends MongoRepository<Lab, String> {
    List<Lab> findByPatientId(int patientId);
}
