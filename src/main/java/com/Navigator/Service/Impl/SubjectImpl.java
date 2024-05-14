package com.Navigator.Service.Impl;

import com.Navigator.Exceptions.NotFoundException;
import com.Navigator.Models.Students;
import com.Navigator.Models.Subject;
import com.Navigator.Repository.StudentRepository;
import com.Navigator.Repository.SubjectRepository;
import com.Navigator.Service.ISubject;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectImpl implements ISubject {

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


  public Subject enrollSubjectFormStudent(Long StudentId,Long SubjectId){
    try {
      Students student= studentRepository.findById(StudentId).orElseThrow(() ->
              new NotFoundException("Student not found with id: " +StudentId)

      );

      Subject subject=subjectRepository.findById(SubjectId).orElseThrow(()-> new NotFoundException("Subject not found with id: " + SubjectId));
      subject.getRegisteredStudents().add(student);
      return  subjectRepository.save(subject);
    }
    catch ( Exception e){
      throw new RuntimeException(e.getMessage());
    }
  }
}
