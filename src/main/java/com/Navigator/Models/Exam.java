package com.Navigator.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exam {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(unique = true)
//    private String examId;
//
//    @ManyToOne
//    private Subject subject;
//
//    @ManyToMany
//    @JoinTable(name = "exam_student",
//            joinColumns = @JoinColumn(name = "exam_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id"))
////    @JsonBackReference
//    private List<Students> enrolledStudents = new ArrayList<>();
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long examId;
    private String name;
    @ManyToOne
    private Subject subject;

    @ManyToMany(mappedBy = "exams")
    @JsonBackReference
    private List<Students> students= new ArrayList<>();

}

