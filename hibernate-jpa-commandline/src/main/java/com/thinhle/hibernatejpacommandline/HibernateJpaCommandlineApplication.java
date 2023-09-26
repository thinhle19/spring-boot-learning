package com.thinhle.hibernatejpacommandline;

import com.thinhle.hibernatejpacommandline.dao.StudentDAO;
import com.thinhle.hibernatejpacommandline.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateJpaCommandlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaCommandlineApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student...");
        Student tempStu = new Student("Paul", "Doe", "ltt@gmail.com");
        System.out.println("Saving the student...");
        studentDAO.save(tempStu);

        System.out.println("Saved student. Generate id: " + tempStu.getId());
    }
}