package com.Navigator.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "ExamID")
    private Long examId;

    @Column(name = "Subject")
    private Long subject;

    @JsonIgnore
    @ManyToMany(mappedBy = "registeredExams")
    private Set<Student> registeredStudents = new HashSet<>();
}

