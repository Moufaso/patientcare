package edu.gmu.patientcare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "nurse")
public class Nurse {
    @Id
    private String _id;
    private int id;
    private String name;
    @Field(name = "department_id")
    private int departmentId;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getDepartmentId() {
        return departmentId;
    }
}
