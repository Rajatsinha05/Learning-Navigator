package com.Navigator.Service.Impl;

import com.Navigator.Models.Students;
import com.Navigator.Repository.StudentRepository;
import com.Navigator.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Students CreateStudent(Students students) {

        return studentRepository.save(students);
    }


    public  String DeleteStudent(Long id) {

        studentRepository.deleteById(id);
        return "Student deleted";

    }     


    public Students getById(Long id) {
        return studentRepository.findById(id);
    }

}
