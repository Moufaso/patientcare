package edu.gmu.patientcare.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import edu.gmu.patientcare.model.Nurse;

public interface NurseRepository extends MongoRepository<Nurse, String>  {
    List<Nurse> findByName(String name);
}
