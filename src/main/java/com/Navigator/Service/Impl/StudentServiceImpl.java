package com.Navigator.Service.Impl;

import com.Navigator.Models.Exam;
import com.Navigator.Models.Students;
import com.Navigator.Models.Subject;
import com.Navigator.Repository.ExamRepository;
import com.Navigator.Repository.StudentRepository;
import com.Navigator.Repository.SubjectRepository;
import com.Navigator.Service.IStudentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

public class StudentServiceImpl implements IStudentService {

  @Autowired
  private StudentRepository studentRepository;
  @Autowired
  private ExamRepository examRepository;
  @Autowired
  private SubjectRepository subjectRepository;

  public Students createStudent(Students students) {
    return studentRepository.save(students);
  }


    public List<Students> getStudentList() {
    return studentRepository.findAll();
  }


    public String deleteStudent(Long id) {
    studentRepository.deleteById(id);
    return "Student deleted";
  }

  public Students getById(Long id) {
    return studentRepository
      .findById(id)
      .orElseThrow(() ->
        new RuntimeException("student not found with id: " + id)
      );
  }

  public Students updateStudent(Long id, Students students) {
    Students stu = studentRepository
      .findById(id)
      .orElseThrow(() ->
        new RuntimeException("student not found with id: " + id)
      );
    stu.setName(students.getName());
    stu.setEnrolledSubjects(students.getEnrolledSubjects());
    stu.setRegistrationId(students.getRegistrationId());
    return studentRepository.save(stu);
  }

    public void enrollStudentToSubject(Long studentId, Long subjectId) {
        Students student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + subjectId));

        student.getEnrolledSubjects().add(subject);
        studentRepository.save(student);
    }

    public void registerStudentForExam(Long studentId, Long examId) {
        Students student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found with id: " + examId));

        student.getRegisteredExams().add(exam);
        studentRepository.save(student);
    }
}
