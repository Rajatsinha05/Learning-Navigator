package com.Navigator.Repository;

import com.Navigator.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByRegistrationId(Long registrationId);
}
