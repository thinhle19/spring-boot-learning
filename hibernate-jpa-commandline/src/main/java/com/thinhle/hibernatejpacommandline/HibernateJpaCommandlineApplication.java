package com.thinhle.hibernatejpacommandline;

import com.thinhle.hibernatejpacommandline.dao.StudentDAO;
import com.thinhle.hibernatejpacommandline.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateJpaCommandlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaCommandlineApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            updateStudents(studentDAO);
        };
    }

    private void updateStudents(StudentDAO studentDAO) {
        System.out.println("updating stud 1...");
        Student stud = studentDAO.findById(1);
        stud.setLastName("Lozz");
        studentDAO.update(stud);

        System.out.println("Result: \n" + studentDAO.findById(1));
    }

    private void findAllStudents(StudentDAO studentDAO) {
        System.out.println("Finding all stud by lastName...");
        List<Student> res = studentDAO.findByLastName("Le");

        for (Student stud : res) {
            System.out.println(stud);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        int id = 11;
        System.out.println("finding student " + id);
        Student a = studentDAO.findById(id);
        if (a == null) {
            System.out.println("not found");
        } else {
            System.out.println(a);
        }
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student...");
        Student tempStu = new Student("Paul", "ABC", "ltt@gmail.com");
        System.out.println("Saving the student...");
        studentDAO.save(tempStu);

        System.out.println("Saved student. Generate id: " + tempStu.getId());
    }
}
