package com.Navigator.Repository;

import com.Navigator.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students,Long> {
}
