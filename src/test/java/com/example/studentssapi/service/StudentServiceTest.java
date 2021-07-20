package com.example.studentssapi.service;

import com.example.studentssapi.entity.Marks;
import com.example.studentssapi.entity.MarksId;
import com.example.studentssapi.repository.MarksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    MarksRepository marksRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testViewAllMarks(){
        List<Marks> l = new ArrayList<>();
        l.add(new Marks(new MarksId(1, 1), 30));
        l.add(new Marks(new MarksId(1, 2), 30));
        l.add(new Marks(new MarksId(1, 3), 30));
        when(marksRepository.findByStudentId(anyInt())).thenReturn(l);
        List<Marks> newList= studentService.viewAllMarks(1);
        assertEquals(l, newList);
    }

    @Test
    void testViewMarksOfASingleSubject(){
        Marks m = new Marks(new MarksId(1,1), 30);
        when(marksRepository.viewMarksOfASingleSubject(1,1)).thenReturn(m);
        Marks newMarks= studentService.viewMarksOfASingleSubject(1,1);
        assertEquals(m, newMarks);
    }

    @Test
    void viewRequestRecheck(){
        String s=studentService.requestRecheck(1,1);
        assertEquals(s, "Request for recheck has been submitted");
    }
}