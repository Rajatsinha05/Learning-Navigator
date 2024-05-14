package com.Navigator.Controllers;

import com.Navigator.Models.Students;
import com.Navigator.Service.Impl.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired
  private StudentServiceImpl studentService;

  @PostMapping
  public ResponseEntity<?> createStudentHandler(
    @Valid @RequestBody Students student
  ) {
    try {
      return new ResponseEntity<>(
        studentService.createStudent(student),
        HttpStatus.CREATED
      );
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping
  public ResponseEntity<?> getStudentListHandler() {
    try {
      return new ResponseEntity<>(
        studentService.getStudentList(),
        HttpStatus.OK
      );
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getStudentByIdHandler(@PathVariable("id") Long id) {
    try {
      return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateStudentHandler(
    @PathVariable("id") Long id,
    @RequestBody Students student
  ) {
    try {
      return new ResponseEntity<>(
        studentService.updateStudent(id, student),
        HttpStatus.OK
      );
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteStudentHandler(@PathVariable("id") Long id) {
    try {
      return new ResponseEntity<>(
        studentService.deleteStudent(id),
        HttpStatus.NO_CONTENT
      );
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/{studentId}/enroll/{subjectId}")
  public ResponseEntity<?> enrollStudentToSubjectHandler(
    @PathVariable("studentId") Long studentId,
    @PathVariable("subjectId") Long subjectId
  ) {
    try {
      studentService.enrollStudentToSubject(studentId, subjectId);
      return ResponseEntity.ok("Student enrolled to subject successfully.");
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("/{studentId}/register/{examId}")
  public ResponseEntity<?> registerStudentForExamHandler(
    @PathVariable("studentId") Long studentId,
    @PathVariable("examId") Long examId
  ) {
    try {
      studentService.registerStudentForExam(studentId, examId);
      return ResponseEntity.ok("Student registered for exam successfully.");
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/test")
  public String testHandler() {
    return "working";
  }
}
