package com.prakharpatil.studentesd.Repository;

import com.prakharpatil.studentesd.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    boolean existsById(long id);
    Student findById(long id);

    boolean existsByEmailAndIdNot(String email, Long id);
    boolean existsByRollNoAndIdNot(String rollNo, Long id);

    int countByDomainId(long domainId);
}