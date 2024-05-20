package com.Navigator.Controllers;

import com.Navigator.Exceptions.NotFoundException;
import com.Navigator.Models.Exam;
import com.Navigator.Service.IExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
        private final IExam examService;

        @Autowired
        public ExamController(IExam examService) {
            this.examService = examService;
        }

        @GetMapping
        public ResponseEntity<List<Exam>> getAllExams() {
            List<Exam> exams = examService.getAllExams();
            if (exams.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(exams);
        }

        @GetMapping("/{examId}")
        public ResponseEntity<Exam> getExamById(@PathVariable Long examId) {
            Exam exam = examService.getExamById(examId);
            if (exam == null) {
                throw new NotFoundException("Exam with ID: " + examId + " not found!");
            }
            return ResponseEntity.ok(exam);
        }

        @PostMapping
        public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
            Exam createdExam = examService.createExam(exam);
            return ResponseEntity.status(201).body(createdExam);
        }

        @DeleteMapping("/{examId}")
        public ResponseEntity<String> deleteExam(@PathVariable Long examId) {
            Exam exam = examService.getExamById(examId);
            if (exam == null) {
                throw new NotFoundException("Exam with ID: " + examId + " not found!");
            }
            examService.deleteExam(examId);
            return ResponseEntity.status(200).body("Exam with ID: " + examId + " deleted successfully.");
        }

        @PostMapping("/{examId}/registerStudent/{registrationId}")
        public ResponseEntity<String> registerStudentForExam(@PathVariable Long examId, @PathVariable Long registrationId) {
            examService.registerStudentForExam(examId, registrationId);
            return ResponseEntity.status(200).body("Student with registration ID: " + registrationId + " registered for exam ID: " + examId + " successfully.");
        }
    }


