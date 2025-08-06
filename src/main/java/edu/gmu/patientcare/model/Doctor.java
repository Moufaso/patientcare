package edu.gmu.patientcare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "doctor")
public class Doctor {
    @Id
    private String _id;
    @Field(name = "id")
    private int id;
    private String name;
    private String specialization;
    @Field(name = "department_id")
    private int departmentId;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSpecialization() {
        return specialization;
    }
    public int getDepartmentId() {
        return departmentId;
    }
}
