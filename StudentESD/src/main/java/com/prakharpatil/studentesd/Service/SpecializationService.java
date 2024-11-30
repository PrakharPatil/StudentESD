package com.prakharpatil.studentesd.Service;


import com.prakharpatil.studentesd.Model.Specialization;
import com.prakharpatil.studentesd.Repository.SpecializationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {

    @Autowired
    private SpecializationRepo specializationRepository;
    public List<Specialization> findAll() {
            List<Specialization> specializations = specializationRepository.findAll();
            return specializations;
    }
}
