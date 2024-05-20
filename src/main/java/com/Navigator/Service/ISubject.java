package com.Navigator.Service;

import com.Navigator.Models.Subject;

import java.util.List;

public interface ISubject {
    List<Subject> getAllSubjects();
    Subject getSubjectById(Long subjectId);
    Subject createSubject(Subject subject);
    void deleteSubject(Long subjectId);


}
