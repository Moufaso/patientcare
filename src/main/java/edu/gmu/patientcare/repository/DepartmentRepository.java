package edu.gmu.patientcare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.gmu.patientcare.model.Department;
import java.util.List;


public interface DepartmentRepository extends MongoRepository<Department, String> {
    //List<Department> findByName(String name);
}
