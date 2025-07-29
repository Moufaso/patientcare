package edu.gmu.patientcare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "department")
public class Department {
    @Id
    private String _id;
    private int id;
    private String name;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
