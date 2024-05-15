package com.Navigator.Service.Impl;

import com.Navigator.Exceptions.NotFoundException;
import com.Navigator.Models.Students;
import com.Navigator.Models.Subject;
import com.Navigator.Repository.StudentRepository;
import com.Navigator.Repository.SubjectRepository;
import com.Navigator.Service.ISubject;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements ISubject {

  @Autowired
  private SubjectRepository subjectRepository;
  @Autowired
  private StudentRepository studentRepository;

  public Subject createSubject(Subject subject) {
    try {
      return subjectRepository.save(subject);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public Subject getSubjectById(Long id) {
    try {
      return subjectRepository
        .findById(id)
        .orElseThrow(() ->
          new NotFoundException("subject not found with id: " + id)
        );
    }
    catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public Subject deleteSubjectById(Long id) {
    try {
      Subject subject = subjectRepository
        .findById(id)
        .orElseThrow(() ->
          new NotFoundException("subject not found with id: " + id)
        );
      subjectRepository.deleteById(id);
      return subject;
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public List<Subject> getSubjectList() {
    try {
      return subjectRepository.findAll();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }
  public Subject updateSubject(Long id, Subject subjectDetails) {
    try {
      Subject subject = subjectRepository.findById(id)
              .orElseThrow(() -> new NotFoundException("Subject not found with id: " + id));

      subject.setName(subjectDetails.getName());

      return subjectRepository.save(subject);
    } catch (NotFoundException e) {
      throw new RuntimeException(e);
    }
  }


  @Override
//  @Transactional
  public Subject enrollSubjectForStudent(Long studentId, Long subjectId) {
    try {
      Students student = studentRepository.findById(studentId)
              .orElseThrow(() -> new NotFoundException("Student not found with id: " + studentId));
      Subject subject = subjectRepository.findById(subjectId)
              .orElseThrow(() -> new NotFoundException("Subject not found with id: " + subjectId));

      student.getSubjects().add(subject);
      subject.getStudents().add(student);

      studentRepository.save(student);
      return subjectRepository.save(subject);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
