package com.n11.demo.repository;

import com.n11.demo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

    Student findByName(String name);
}
