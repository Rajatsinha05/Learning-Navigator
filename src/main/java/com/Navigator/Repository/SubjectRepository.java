package com.Navigator.Repository;

import com.Navigator.Models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    Subject findBySubjectId(Long subjectId);
}
