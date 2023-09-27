package com.thinhle.hibernatejpacommandline.dao;

import com.thinhle.hibernatejpacommandline.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(int id);

    int deleteByLastName(String lastName);
}
