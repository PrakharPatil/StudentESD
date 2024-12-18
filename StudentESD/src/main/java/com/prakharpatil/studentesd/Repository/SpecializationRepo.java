package com.prakharpatil.studentesd.Repository;

import com.prakharpatil.studentesd.Model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepo extends JpaRepository<Specialization, Integer> {
}
