package com.Navigator.Service;

import com.Navigator.Models.Exam;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IExam {
    List<Exam> getAllExams();

    Exam getExamById(int examId);

    Exam createExam(Exam exam);

    void deleteExam(int examId);

    void registerStudentForExam(int examId, int registrationId);
}
