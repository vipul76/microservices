package com.ms.student_service.controller;

import com.ms.student_service.StudentService.StudentService;
import com.ms.student_service.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/hi")
    public String hello(){
        return "Hello Pihu, vipul loves you and wan't to marry you";
    }

    @GetMapping(value = "/all-student")
    public ResponseEntity<?> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return students!=null? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>("No students found", HttpStatus.NOT_FOUND);
    }
}
