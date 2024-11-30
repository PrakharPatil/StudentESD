package com.prakharpatil.studentesd.Service;

import com.prakharpatil.studentesd.Model.Admin;
import com.prakharpatil.studentesd.Model.StudentPrinciple;
import com.prakharpatil.studentesd.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepo.findByUsername(username);
        return new StudentPrinciple(admin);
    }
}
