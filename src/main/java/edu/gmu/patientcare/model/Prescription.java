package edu.gmu.patientcare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "prescription")
public class Prescription {
    @Id
    private String _id;
    private int id;
    @Field(name = "appointment_id")
    private int appointmentId;
    private String medication;
    public int getId() {
        return id;
    }
    public int getAppointmentId() {
        return appointmentId;
    }
    public String getMedication() {
        return medication;
    }
}
