package com.Navigator.Controllers;

import com.Navigator.Models.Student;
import com.Navigator.Service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired
  private StudentServiceImpl studentService;

  @PostMapping(consumes = "application/json", produces = "application/json")
  public ResponseEntity<Student> createStudentHandler(@RequestBody Student student) {
    Student createdStudent = studentService.createStudent(student);
    return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
  }

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<Student>> getStudentListHandler() {
    List<Student> students = studentService.getStudentList();
    return new ResponseEntity<>(students, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudentByIdHandler(@PathVariable("id") Long id) {
    Student student = studentService.getById(id);
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Student> updateStudentHandler(
          @PathVariable("id") Long id,
          @RequestBody Student student) {
    Student updatedStudent = studentService.updateStudent(id, student);
    return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStudentHandler(@PathVariable("id") Long id) {
    studentService.deleteStudent(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping(value = "/{studentId}/enroll/{subjectId}", produces = "application/json")
  public ResponseEntity<String> enrollStudentToSubjectHandler(
          @PathVariable("studentId") Long studentId,
          @PathVariable("subjectId") Long subjectId) {
    studentService.enrollStudentToSubject(studentId, subjectId);
    return ResponseEntity.ok("Student enrolled to subject successfully.");
  }

  @PostMapping(value = "/{studentId}/register/{examId}", produces = "application/json")
  public ResponseEntity<String> registerStudentForExamHandler(
          @PathVariable("studentId") Long studentId,
          @PathVariable("examId") Long examId) {
    studentService.registerStudentForExam(studentId, examId);
    return ResponseEntity.ok("Student registered for exam successfully.");
  }

  @GetMapping("/test")
  public ResponseEntity<String> testHandler() {
    return ResponseEntity.ok("working");
  }
}
