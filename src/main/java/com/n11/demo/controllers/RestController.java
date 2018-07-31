package com.n11.demo.controllers;

import com.n11.demo.model.Student;
import com.n11.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/")
    public String testController() {
        return "Welcome";
    }

    @RequestMapping("/insert")
    public Student insert(@RequestParam String name, @RequestParam String number) {
        return studentRepository.save(new Student(name, number));
    }

    @RequestMapping("/get/{name}")
    public Student get(@PathVariable String name) {
        return studentRepository.findByName(name);
    }

    @RequestMapping("/update/{name}")
    public Student update(@PathVariable String name, @RequestParam String number) {
        Student student = studentRepository.findByName(name);
        student.setNumber(number);
        return studentRepository.save(student);

    }

    @RequestMapping("/list")
    public List<Student> list() {
        return studentRepository.findAll();
    }


    @RequestMapping("/delete/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        Student student = studentRepository.findByName(name);
        studentRepository.delete(student);
        return ResponseEntity.noContent().build();
    }

}
