package com.prakharpatil.studentesd.Controller;


import com.prakharpatil.studentesd.Model.Specialization;
import com.prakharpatil.studentesd.Service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(originPatterns = "http://localhost:*")
@RestController
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @GetMapping("/getspecializations")
    public ResponseEntity<List<Specialization>> getAllSpecializations() {
        List<Specialization> specializations = specializationService.findAll();
        return ResponseEntity.ok(specializations);
    }
}
