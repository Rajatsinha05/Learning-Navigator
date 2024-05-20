package com.Navigator.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Student {
    @Id
    @Column(unique = true, name = "RegistrationID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registrationId;

    @Column(name = "Name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_subjects",
            joinColumns = @JoinColumn(name = "RegistrationID"),
            inverseJoinColumns = @JoinColumn(name = "SubjectID")
    )
    private Set<Subject> enrolledSubjects = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "student_exams",
            joinColumns = @JoinColumn(name = "StudentID"),
            inverseJoinColumns = @JoinColumn(name = "ExamID")
    )
    private Set<Exam> registeredExams = new HashSet<>();

}
