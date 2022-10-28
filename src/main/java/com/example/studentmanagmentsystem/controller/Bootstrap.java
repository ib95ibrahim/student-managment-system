package com.example.studentmanagmentsystem.controller;

import com.example.studentmanagmentsystem.entity.Student;
import com.example.studentmanagmentsystem.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public Bootstrap(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Student student1 = new Student("ibrahim","zeroual","ib@gmail");
        //studentRepository.save(student1);

        Student student2 = new Student("omar","","om@gmail");
        //studentRepository.save(student2);

        Student student3 = new Student("mohamed","zeroual","mh@gmail");
        //studentRepository.save(student3);

    }
}
