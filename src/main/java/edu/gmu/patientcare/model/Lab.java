package edu.gmu.patientcare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "lab")
public class Lab {
    @Id
    private String _id;
    private int id;
    @Field(name = "patient_id")
    private int patientId;
    @Field(name = "nurse_id")
    private int nurseId;
    private String date;
    private String time;
    private String test;
    public int getId() {
        return id;
    }
    public int getPatientId() {
        return patientId;
    }
    public int getNurseId() {
        return nurseId;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getTest() {
        return test;
    }
}