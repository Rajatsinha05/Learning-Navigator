package com.Navigator.Service;

import com.Navigator.Models.Subject;

import java.util.List;

public interface ISubject {
     Subject createSubject(Subject subject);
    Subject getSubjectById(Long id);
    Subject deleteSubjectById(Long id);
    List<Subject> getSubjectList();
    Subject enrollSubjectFormStudent(Long studentId, Long subjectId);
}
