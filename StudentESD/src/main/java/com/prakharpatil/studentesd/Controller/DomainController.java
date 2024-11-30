package com.prakharpatil.studentesd.Controller;


import com.prakharpatil.studentesd.Model.Domain;
import com.prakharpatil.studentesd.Service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(originPatterns = "http://localhost:*")
@RestController
public class DomainController {

    @Autowired
    private DomainService domainService;


    @GetMapping("/getdomains")
    public ResponseEntity<List<Domain>> getAllDomains() {
        ResponseEntity<List<Domain>> domains = domainService.findAll();
        return ResponseEntity.ok(domains.getBody());
    }
}
