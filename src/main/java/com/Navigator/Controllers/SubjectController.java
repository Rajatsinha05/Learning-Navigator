package com.Navigator.Controllers;


import com.Navigator.Models.Subject;
import com.Navigator.Service.Impl.SubjectServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/subject",consumes = "application/json", produces = "application/json")
public class SubjectController {
    @Autowired
    private SubjectServiceImpl subjectService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createHandler(@Valid @RequestBody Subject subject){
        try{
            return new ResponseEntity<>(subjectService.createSubject(subject), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public  ResponseEntity<?> getSubjectHandler(){
        try{
            return new ResponseEntity<>(subjectService.getSubjectList(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{subjectId}")
    public  ResponseEntity<?> deleteHandler(@PathVariable("subjectId") Long subjectId){
        try{
            return new ResponseEntity<>(subjectService.deleteSubjectById(subjectId),HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(value = "/{subjectId}/enroll/{studentId}",consumes = "application/json", produces = "application/json")
    public  ResponseEntity<?> enrollHandler(@PathVariable("subjectId") Long subjectId, @PathVariable("studentId") Long studentId){

        try{
            return new ResponseEntity<>(subjectService.enrollSubjectForStudent(subjectId, studentId),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/test")
    public ResponseEntity<?> testHandler(){
        try{
            return new ResponseEntity<>("working",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
