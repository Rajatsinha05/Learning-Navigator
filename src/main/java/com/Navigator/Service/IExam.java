package com.Navigator.Service;

import com.Navigator.Models.Exam;

import java.util.List;

public interface IExam {
    Exam createExam(Exam exam);

    Exam getExamById(long id);

    List<Exam> getExamList();

    Exam deleteById(Long id);
}
