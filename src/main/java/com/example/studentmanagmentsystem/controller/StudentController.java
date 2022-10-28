package com.example.studentmanagmentsystem.controller;

import com.example.studentmanagmentsystem.entity.Student;
import com.example.studentmanagmentsystem.service.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping({"/students","/"," ","/index"})
    String listStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/student/new")
        String addNewStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "addStudent";
        }

    @PostMapping("/students")
    String afterAddingStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
        }

    @GetMapping("/students/edit/{id}")
    String updateStudentForm(@PathVariable Long id,Model model){

        var student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "edit_student";
    }

    @PostMapping("/students/update/{id}")
    String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student newStudent){

        var existingStudent = studentService.getStudentById(id);

        existingStudent.setEmail(newStudent.getEmail());
        existingStudent.setFirstName(newStudent.getFirstName());
        existingStudent.setLastName(newStudent.getLastName());

        studentService.saveStudent(existingStudent);

        return "redirect:/students";
    }

    @GetMapping("students/delete/{id}")
    String deleteStudent(@PathVariable Long id){
        var student = studentService.getStudentById(id);
        studentService.deleteStudent(student);
        return "redirect:/students";
    }

}
