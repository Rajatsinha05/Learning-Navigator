package com.Navigator.Service.Impl;

import com.Navigator.Exceptions.NotFoundException;
import com.Navigator.Models.Exam;
import com.Navigator.Models.Student;
import com.Navigator.Models.Subject;
import com.Navigator.Repository.ExamRepository;
import com.Navigator.Repository.StudentRepository;
import com.Navigator.Service.IExam;
import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ExamImpl implements IExam {
  @Autowired
  private ExamRepository examRepository;

  @Autowired
  private StudentServiceImpl studentService;

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public List<Exam> getAllExams() {
    return examRepository.findAll();
  }

  @Override
  public Exam getExamById(Long examId) {
    try{
      return examRepository.findByExamId(examId);
    }catch(NotFoundException e){
      System.out.println("Exam not Found with ID: " + examId);
    }
    return null;
  }

  @Override
  public Exam createExam(Exam exam) {
    return examRepository.save(exam);
  }

  @Override
  public void deleteExam(Long examId) {
    try{
      examRepository.delete(examRepository.findByExamId(examId));
    }catch (Exception e){
      throw new NotFoundException("No such exam existed with id: " + examId);
    }

  }

  @Override

  public void registerStudentForExam(Long examId, Long registrationId) {
    Exam exam = getExamById(examId);
    Student student = studentService.getStudentByRegistrationId(registrationId);

    if (student == null) {
      throw new NotFoundException("Student not found with Registration ID: " + registrationId);
    }

    if (exam == null) {
      throw new NotFoundException("Exam not found with ID: " + examId);
    }

    boolean enrolledInSubject = false;

    for (Subject subject : student.getEnrolledSubjects()) {
      if (subject.getSubjectId().equals(exam.getSubject().getSubjectId())) {
        exam.getRegisteredStudents().add(student);
        enrolledInSubject = true;
        break; // No need to check other subjects
      }
    }

    if (!enrolledInSubject) {
      throw new NotFoundException("Student is not enrolled in Subject ID: " + exam.getSubject().getSubjectId());
    }

    examRepository.save(exam);
  }

}
