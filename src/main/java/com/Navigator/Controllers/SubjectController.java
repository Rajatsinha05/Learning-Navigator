package com.Navigator.Controllers;

import com.Navigator.Exceptions.NotFoundException;
import com.Navigator.Models.Subject;

import com.Navigator.Service.Impl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);
    @Autowired
    private  SubjectServiceImpl subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        if (subjects.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        if (subject == null) {
            throw new NotFoundException("Subject with ID: " + subjectId + " not found!");
        }
        return ResponseEntity.ok(subject);
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject createdSubject = subjectService.createSubject(subject);
        return ResponseEntity.status(201).body(createdSubject);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        if (subject == null) {
            throw new NotFoundException("Subject with ID: " + subjectId + " not found!");
        }
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.status(200).body("Subject with ID: " + subjectId + " deleted successfully.");
    }


}
