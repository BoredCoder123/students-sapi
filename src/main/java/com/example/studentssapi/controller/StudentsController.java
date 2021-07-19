package com.example.studentssapi.controller;

import com.example.studentssapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.studentssapi.entity.Marks;

import java.util.List;

@RestController
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/viewAllMarks/{studentId}")
    public List<Marks> viewAllMarks(@PathVariable int studentId){
        return studentService.viewAllMarks(studentId);
    }

    @GetMapping("/viewMarksOfASingleSubject/{studentId}/{subjectId}")
    public Marks viewMarksOfASingleSubject(@PathVariable int studentId, @PathVariable int subjectId){
        return studentService.viewMarksOfASingleSubject(studentId, subjectId);
    }

    @GetMapping("/requestRecheck/{studentId}/{subjectId}")
    public String requestRecheck(@PathVariable int studentId, @PathVariable int subjectId) {
        return studentService.requestRecheck(studentId, subjectId);
    }
}
