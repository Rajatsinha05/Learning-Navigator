package com.Navigator.Controllers;

import com.Navigator.Models.Subject;
import com.Navigator.Service.Impl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectServiceImpl subjectService;

    @PostMapping()
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject createdSubject = subjectService.createSubject(subject);
        return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Subject>> getSubjects() {
        List<Subject> subjects = subjectService.getSubjectList();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Void> deleteSubject(@PathVariable("subjectId") Long subjectId) {
        subjectService.deleteSubjectById(subjectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{subjectId}/enroll/{studentId}")
    public ResponseEntity<String> enrollStudentInSubject(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("studentId") Long studentId) {
        subjectService.enrollSubjectForStudent(subjectId, studentId);
        return ResponseEntity.ok("Student enrolled in subject successfully.");
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("working");
    }
}
