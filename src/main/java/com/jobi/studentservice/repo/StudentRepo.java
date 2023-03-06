package com.jobi.studentservice.repo;
import com.jobi.studentservice.model.Students;
import com.jobi.studentservice.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository


public interface StudentRepo extends JpaRepository<Students, Long> {
    Optional<Students> findByEmail(String email);
//@Query(value = "select * from students where course= ?",nativeQuery = true)
//    List<Students> getAllStudents();
}

