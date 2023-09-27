package com.thinhle.hibernatecrudapi.rest;

import com.thinhle.hibernatecrudapi.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Thinh", "Le"));
        students.add(new Student("Nhan", "Huynh"));
        students.add(new Student("Linh", "Nguyen"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        if (id >= students.size() || id < 0) {
            throw new StudentNotFoundException(String.format("Student with id %d can't be found", id));
        }

        return students.get(id);
    }
}

