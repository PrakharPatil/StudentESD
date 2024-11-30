package com.prakharpatil.studentesd.Controller;

import com.prakharpatil.studentesd.Model.Admin;
import com.prakharpatil.studentesd.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "http://localhost:*")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin admin) {
        List<Admin> lt = getAllAdmins();
       return adminService.login(admin,lt);
    }



}