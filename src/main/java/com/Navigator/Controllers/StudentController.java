package com.Navigator.Controllers;

import com.Navigator.Exceptions.NotFoundException;
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

  @GetMapping
  public ResponseEntity<List<Student>> getAllStudents(){
    List<Student> students = studentService.getAllStudents();
    return new ResponseEntity<>(students,HttpStatus.OK);
  }

  @GetMapping("/{registrationId}")
  public ResponseEntity<Student> getStudentByRegistrationId(@PathVariable Long registrationId){
    Student student = studentService.getStudentByRegistrationId(registrationId);
    if(student == null){
      return ResponseEntity.notFound().build();
    }
    return new  ResponseEntity<>(student,HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Student> createStudent(@RequestBody Student student){
    Student createdStudent = studentService.createStudent(student);
    return new ResponseEntity<>(createdStudent,HttpStatus.CREATED);
  }

  @PutMapping("/{registrationId}")
  public ResponseEntity<Student> updateStudent(@PathVariable Long registrationId, @RequestBody Student student){
    Student updatedStudent = studentService.updateStudent(registrationId,student);
    if(updatedStudent == null){
      return ResponseEntity.notFound().build();
    }
    return  new  ResponseEntity<>(updatedStudent,HttpStatus.OK);
  }

  @DeleteMapping("/{registrationId}")
  public ResponseEntity<String> deleteStudent(@PathVariable Long registrationId){
    try{
      studentService.deleteStudent(registrationId);
      return  new  ResponseEntity<>("Student Deleted successfully ",HttpStatus.OK);
    }catch (Exception e){
      throw new NotFoundException("No such Student found with id: " + registrationId);
    }

  }

  @PostMapping("/{registrationId}/enroll/{subjectId}")
  public ResponseEntity<String> enrollStudentInSubject(@PathVariable Long registrationId, @PathVariable Long subjectId){
    studentService.enrollStudentInSubject(registrationId, subjectId);
    return new  ResponseEntity<>("Student enroll successfully ",HttpStatus.OK);
  }

  @PostMapping("/{registrationId}/register/{examId}")
  public ResponseEntity<String> registerStudentForExam(@PathVariable Long registrationId, @PathVariable Long examId){
    try {
      studentService.registerStudentForExam(registrationId, examId);
      return new  ResponseEntity<>("Student Register successfully ",HttpStatus.OK);
    }catch(Exception e){
      throw new NotFoundException("Student is not enrolled in Subject for Exam: " + examId);
    }
  }

  @GetMapping("/test")
  public ResponseEntity<String> testHandler() {
    return ResponseEntity.ok("working");
  }
}
