package com.prakharpatil.studentesd.Repository;

import com.prakharpatil.studentesd.Model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DomainRepo extends JpaRepository<Domain, Long> {
}
