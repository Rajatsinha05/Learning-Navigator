package com.Navigator.Service.Impl;

import com.Navigator.Exceptions.NotFoundException;
import com.Navigator.Exceptions.BadRequestException;
import com.Navigator.Models.Exam;
import com.Navigator.Models.Student;
import com.Navigator.Models.Subject;
import com.Navigator.Repository.ExamRepository;
import com.Navigator.Repository.StudentRepository;
import com.Navigator.Repository.SubjectRepository;
import com.Navigator.Service.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByRegistrationId(Long registrationId) {
        try{
            return studentRepository.findByRegistrationId(registrationId);
        }catch(NotFoundException e){
            System.out.println("Student not found with ID: " + registrationId);
        }
        return null;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(int registrationId, Student updatedStudent) {
        Student existingStudent = studentRepository.findByRegistrationId(registrationId);
        if(existingStudent != null){
            updatedStudent.setRegistrationId(existingStudent.getRegistrationId());
            return studentRepository.save(updatedStudent);
        }
        return null;
    }

    @Override
    public void deleteStudent(int registrationId) {
        try{
            Student student = studentRepository.findByRegistrationId(registrationId);
            studentRepository.delete(student);
        }catch(Exception e){
            throw new NotFoundException("No such Student found with id: " + registrationId);
        }
    }

    @Override
    public void enrollStudentInSubject(int registrationId, int subjectId) {
        Student student = studentRepository.findByRegistrationId(registrationId);
        if(student != null){
            Subject subject = new Subject();
            subject.setSubjectId(subjectId);
            student.getEnrolledSubjects().add(subject);
            studentRepository.save(student);
        }else{
            throw new NotFoundException("Student not found with ID: " + registrationId);
        }
    }

    @Override
    public void registerStudentForExam(int registrationId, int examId) {
        Student student = studentRepository.findByRegistrationId(registrationId);
        if(student != null){
            Exam exam = new Exam();
            exam.setExamId(examId);
            student.getRegisteredExams().add(exam);
            studentRepository.save(student);
        }else{
            throw new NotFoundException("Student not found with ID: " + registrationId);
        }
    }
}
