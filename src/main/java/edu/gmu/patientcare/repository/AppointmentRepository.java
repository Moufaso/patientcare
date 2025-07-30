package edu.gmu.patientcare.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import edu.gmu.patientcare.model.Appointment;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
   List<Appointment> findByPatientId(int patientId);
}
