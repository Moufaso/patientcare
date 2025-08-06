package edu.gmu.patientcare.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import edu.gmu.patientcare.model.Appointment;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
   List<Appointment> findByPatientId(int patientId);
   
   /* -------- Appointments by department name -------- */
   @Aggregation(pipeline = {
       "{ $lookup: { from: 'doctor', localField: 'doctor_id', foreignField: 'id', as: 'doctor' } }",
       "{ $unwind: '$doctor' }",
       "{ $lookup: { from: 'department', localField: 'doctor.department_id', foreignField: 'id', as: 'dept' } }",
       "{ $unwind: '$dept' }",
       "{ $match: { 'dept.name': ?0 } }"
   })
   List<Appointment> findAppointmentsByDepartment(String departmentName);
   
   @Query("{ 'id': ?0 }")
   Optional<Appointment> findByBusinessId(int id);
   
   @Aggregation(pipeline = {
		    "{ $lookup: { from: 'doctor', localField: 'doctor_id', foreignField: 'id', as: 'doctor' } }",
		    "{ $unwind: '$doctor' }",
		    "{ $lookup: { from: 'department', localField: 'doctor.department_id', foreignField: 'id', as: 'department' } }",
		    "{ $unwind: '$department' }",
		    "{ $group: { _id: '$department.name', count: { $sum: 1 } } }",
		    "{ $project: { _id: 0, name: '$_id', value: '$count' } }"
		})
		List<Map<String, Object>> countAppointmentsByDepartment();

   
}
