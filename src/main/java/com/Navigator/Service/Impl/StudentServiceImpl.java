package com.Navigator.Service.Impl;

import com.Navigator.Exceptions.NotFoundException;
import com.Navigator.Exceptions.BadRequestException;
import com.Navigator.Models.Exam;
import com.Navigator.Models.Students;
import com.Navigator.Models.Subject;
import com.Navigator.Repository.ExamRepository;
import com.Navigator.Repository.StudentRepository;
import com.Navigator.Repository.SubjectRepository;
import com.Navigator.Service.IStudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Students createStudent(Students students) {
        return studentRepository.save(students);
    }

    @Override
    public List<Students> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public String deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new NotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
        return "Student deleted";
    }

    @Override
    public Students getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found with id: " + id));
    }

    @Override
    public Students updateStudent(Long id, Students studentDetails) {
        Students student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found with id: " + id));
        student.setName(studentDetails.getName());
        student.setSubjects(studentDetails.getSubjects());
        student.setExams(studentDetails.getExams());

        return studentRepository.save(student);
    }

    @Override
    public void enrollStudentToSubject(Long studentId, Long subjectId) {
        Students student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student not found with id: " + studentId));

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new NotFoundException("Subject not found with id: " + subjectId));

        student.getSubjects().add(subject);
        studentRepository.save(student);
    }

    @Override
    public void registerStudentForExam(Long studentId, Long examId) {
        Students student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student not found with id: " + studentId));

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new NotFoundException("Exam not found with id: " + examId));

        student.getExams().add(exam);
        studentRepository.save(student);
    }
}
