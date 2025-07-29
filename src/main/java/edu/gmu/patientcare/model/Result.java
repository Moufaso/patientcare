package edu.gmu.patientcare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "result")
public class Result {
    @Id
    private String _id;
    private int id;
    @Field(name = "lab_id")
    private int labId;
    private String result;
    public int getId() {
        return id;
    }
    public int getLabId() {
        return labId;
    }
    public String getResult() {
        return result;
    }
}
