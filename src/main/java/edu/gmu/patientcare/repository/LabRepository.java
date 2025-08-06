package edu.gmu.patientcare.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import edu.gmu.patientcare.model.Lab;
//import edu.gmu.patientcare.model.Lab;

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

	@Query("{ 'id': ?0 }")
	Optional<Lab> findByIdInt(int id);

	@Aggregation(pipeline = {
			"{ $lookup: { from: 'nurse', localField: 'nurse_id', foreignField: 'id', as: 'nurse' } }",
			"{ $unwind: '$nurse' }",
			"{ $group: { _id: '$nurse.name', count: { $sum: 1 } } }",
			"{ $project: { _id: 0, name: '$_id', count: 1 } }"
	})
	List<Map<String, Object>> countLabsByNurse();


}
