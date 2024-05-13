package com.Navigator.Service.Impl;

import com.Navigator.Models.Exam;
import com.Navigator.Repository.ExamRepository;
import com.Navigator.Service.IExam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ExamImpl implements IExam {

  @Autowired
  private ExamRepository examRepository;

  public Exam createExam(Exam exam) {
    return examRepository.save(exam);
  }

  public Exam getExamById(long id) {
    return examRepository
      .findById(id)
      .orElseThrow(() -> new RuntimeException("exam not found with id: " + id));
  }

  public List<Exam> getExamList() {
    return examRepository.findAll();
  }

  public Exam deleteById(Long id) {
    Exam exam = examRepository
      .findById(id)
      .orElseThrow(() -> new RuntimeException("exam not found with id: " + id));

    examRepository.deleteById(id);
    return exam;
  }
}
