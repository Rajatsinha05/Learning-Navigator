package com.Navigator.Service;

import com.Navigator.Models.Students;

import java.util.List;

public interface IStudentService {
    Students createStudent(Students students);

    List<Students> getStudentList();

    String deleteStudent(Long id);

    Students getById(Long id);

    Students updateStudent(Long id, Students students);

    void enrollStudentToSubject(Long studentId, Long subjectId);

    void registerStudentForExam(Long studentId, Long examId);
}
