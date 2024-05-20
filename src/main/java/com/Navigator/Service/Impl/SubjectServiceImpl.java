package com.Navigator.Service.Impl;

import com.Navigator.Exceptions.NotFoundException;
import com.Navigator.Models.Subject;
import com.Navigator.Repository.SubjectRepository;
import com.Navigator.Service.ISubject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectServiceImpl implements ISubject {

  @Autowired
  private SubjectRepository subjectRepository;

  @Override
  public List<Subject> getAllSubjects() {
    return subjectRepository.findAll();
  }

  @Override
  public Subject getSubjectById(Long subjectId) {
    try{
      return subjectRepository.findBySubjectId(subjectId);
    }catch(NotFoundException e){
      System.out.println("Subject not found with ID: " + subjectId);
    }
    return null;
  }

  @Override
  public Subject createSubject(Subject subject) {
    return subjectRepository.save(subject);
  }

  @Override
  public void deleteSubject(Long subjectId) {
    try{
      Subject subject = subjectRepository.findBySubjectId(subjectId);
      subjectRepository.delete(subject);
    }catch(Exception e){
      throw new NotFoundException("No such subject with id: " + subjectId);
    }
  }



}
