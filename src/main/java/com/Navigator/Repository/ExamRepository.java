package com.Navigator.Repository;

import com.Navigator.Models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam ,Long> {
    Exam findByExamId(Long examId);
}
