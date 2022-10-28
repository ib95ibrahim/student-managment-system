package com.example.studentmanagmentsystem.service.impl;

import com.example.studentmanagmentsystem.entity.Student;
import com.example.studentmanagmentsystem.repository.StudentRepository;
import com.example.studentmanagmentsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long Id) {
        return studentRepository.findById(Id).get();
    }

    @Override
    public Student updateStudent(Student student) {
       return studentRepository.save(student) ;
    }

    @Override
    public Student deleteStudent(Student student) {
        studentRepository.delete(student);
        return student;
    }


}
