package com.Navigator.Service;

import com.Navigator.Models.Exam;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IExam {
    List<Exam> getAllExams();

    Exam getExamById(Long examId);

    Exam createExam(Exam exam);

    void deleteExam(Long examId);

    void registerStudentForExam(Long examId, Long registrationId);
}
