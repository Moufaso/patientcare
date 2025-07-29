package edu.gmu.patientcare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.gmu.patientcare.model.Prescription;
import java.util.List;

public interface PrescriptionRepository extends MongoRepository<Prescription, String> {
    List<Prescription> findByAppointmentId(int appointmentId);
}
