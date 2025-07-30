package edu.gmu.patientcare.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import edu.gmu.patientcare.model.Lab;

public interface LabRepository extends MongoRepository<Lab, String> {
    List<Lab> findByPatientId(int patientId);
    
    /* -------- Labs by department name -------- */
    @Aggregation(pipeline = {
        "{ $lookup: { from: 'nurse', localField: 'nurse_id', foreignField: 'id', as: 'nurse' } }",
        "{ $unwind: '$nurse' }",
        "{ $lookup: { from: 'department', localField: 'nurse.department_id', foreignField: 'id', as: 'dept' } }",
        "{ $unwind: '$dept' }",
        "{ $match: { 'dept.name': ?0 } }"
    })
    List<Lab> findLabsByDepartment(String departmentName);
    
    
}
