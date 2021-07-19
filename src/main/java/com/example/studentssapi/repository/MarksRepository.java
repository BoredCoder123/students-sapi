package com.example.studentssapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studentssapi.entity.Marks;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Integer> {
    @Query(nativeQuery=true, value="SELECT * FROM marks where student_id=?1")
    public List<Marks> findByStudentId(int studentId);

    @Query(nativeQuery=true, value="SELECT * FROM marks where student_id=?1 and subject_id=?2")
    Marks viewMarksOfASingleSubject(int studentId, int subjectId);


}
