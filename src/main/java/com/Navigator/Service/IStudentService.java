package com.Navigator.Service;

import com.Navigator.Models.Student;

import java.util.List;

public Longerface IStudentService {
    List<Student> getAllStudents();
    Student getStudentByRegistrationId(Long registrationId);
    Student createStudent(Student student);
    Student updateStudent(Long registrationId, Student updatedStudent);
    void deleteStudent(Long registrationId);
    void enrollStudentInSubject(Long registrationId, Long subjectId);
    void registerStudentForExam(Long registrationId, Long examId);
}
