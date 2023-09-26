package com.thinhle.hibernatejpacommandline.dao;

import com.thinhle.hibernatejpacommandline.entity.Student;
import org.springframework.stereotype.Repository;

@Repository // support component scanning
// translate JDBC exceptions (check later)
public class StudentDAOImpl implements StudentDAO {
    @Override
    public void save(Student student) {

    }
}
