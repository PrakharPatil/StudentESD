package com.prakharpatil.studentesd.Service;

import com.prakharpatil.studentesd.Model.Admin;
import com.prakharpatil.studentesd.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;



    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    public ResponseEntity<?> login(Admin admin, List<Admin> lt) {
        String username = admin.getUsername();
        String password = admin.getPassword();

//        System.out.print(lt);
//        for (int i = 0; i < lt.size(); i++) {
//            if (lt.get(i).getUsername().equals(username) && lt.get(i).getPassword().equals(password))
//                return "Login successful";
//        }
//        return "Login failed";
        Admin authenticatedAdmin = adminRepo.findByUsernameAndPassword(username, password);

        if (authenticatedAdmin != null) {
            return ResponseEntity.ok("Login Successful");
            //return "Yes";
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            //return "No";
        }
    }
}
