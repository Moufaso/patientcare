package edu.gmu.patientcare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "appointment")
public class Appointment {
    @Id
    private String _id;
    private int id;
    @Field(name = "patient_id")
    private int patientId;
    @Field(name = "doctor_id")
    private int doctorId;
    private String date;
    private String time;
    private String reason;
    public int getId() {
        return id;
    }
    public int getPatientId() {
        return patientId;
    }
    public int getDoctorId() {
        return doctorId;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getReason() {
        return reason;
    }
}
