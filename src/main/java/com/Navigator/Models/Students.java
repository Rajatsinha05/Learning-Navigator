package com.Navigator.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String registrationId;

    private String name;

    @ManyToMany
    @JoinTable(name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> enrolledSubjects = new ArrayList<>();

    @ManyToMany(mappedBy = "enrolledStudents")
    private List<Exam> registeredExams = new ArrayList<>();

}
