package com.Navigator.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long subjectId;
    private String subjectName;
    @ManyToMany(mappedBy="enrolledSubjects")
    private List<Students> registerStudents;
}
