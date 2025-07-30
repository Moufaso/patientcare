package edu.gmu.patientcare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.gmu.patientcare.model.LabResult;
import java.util.List;

public interface LabResultRepository extends MongoRepository<LabResult, String> {
    List<LabResult> findByLabId(int labId);
}
