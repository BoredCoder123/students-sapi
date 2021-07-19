package com.example.studentssapi.service;

import com.example.studentssapi.entity.Marks;
import com.example.studentssapi.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private MarksRepository marksRepository;

    public List<Marks> viewAllMarks(int studentId) {
        return marksRepository.findByStudentId(studentId);
    }

    public Marks viewMarksOfASingleSubject(int studentId, int subjectId) {
        return marksRepository.viewMarksOfASingleSubject(studentId, subjectId);
    }

    public String requestRecheck(int studentId, int subjectId) {
        return "Request for recheck has been submitted";
    }
}
