package com.prakharpatil.studentesd.Repository;

import com.prakharpatil.studentesd.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepo extends JpaRepository<Admin, String> {
    Admin findByUsername(String username);

    Admin findByUsernameAndPassword(String username, String password);
}
