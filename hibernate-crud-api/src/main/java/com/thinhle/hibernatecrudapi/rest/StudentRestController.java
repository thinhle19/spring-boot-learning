package com.thinhle.hibernatecrudapi.rest;

import com.thinhle.hibernatecrudapi.entity.Student;
import jakarta.annotation.PostConstruct;
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
        return students.get(id);
    }
}
