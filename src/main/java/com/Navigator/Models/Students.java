package com.Navigator.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Students {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String registrationId;
    private String name;

    @ManyToMany
    private List<Exam>regsterExam;
    @ManyToMany
    private  List<Subject> enrolledSubjects;
}
