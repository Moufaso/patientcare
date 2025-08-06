package edu.gmu.patientcare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "patient")
public class Patient {
    @Id
    private String _id;
    @Field(name = "id") // custom ID
    private int id;
    private String name;
    @Field(name = "blood_type")
    private String bloodType;
    private int age;
    private String gender;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBloodType() {
        return bloodType;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
}
