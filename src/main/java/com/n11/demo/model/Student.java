package com.n11.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;


@Document(collection = "students")
public class Student implements Serializable {

    @Id
    private String id;

    private String name;
    private String number;

    public Student(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Student() {
    }
}
