package com.prakharpatil.studentesd.Service;


import com.prakharpatil.studentesd.Model.Domain;
import com.prakharpatil.studentesd.Repository.DomainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainService {

    @Autowired
    private DomainRepo domainRepository;
    public ResponseEntity<List<Domain>> findAll() {
        List<Domain> domains = domainRepository.findAll();
        return ResponseEntity.ok(domains);
    }
}
