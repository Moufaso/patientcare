package edu.gmu.patientcare.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
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
   
}
