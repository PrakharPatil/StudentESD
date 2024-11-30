package com.prakharpatil.studentesd.Service;


import com.prakharpatil.studentesd.Model.Student;
import com.prakharpatil.studentesd.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepo studentRepository;

    @Autowired
    public StudentService(StudentRepo studentRepository) {
        this.studentRepository = studentRepository;
    }

    public boolean existsById(long id) {
        return studentRepository.existsById(id);
    }

    public Optional<Student> findById(long id) {
        return Optional.ofNullable(studentRepository.findById(id));
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public int countByDomainId(long domainId) {
        return studentRepository.countByDomainId(domainId);
    }

    public boolean existsByEmailAndIdNot(String email, Long id) {
        return studentRepository.existsByEmailAndIdNot(email, id);
    }

    public boolean existsByRollNoAndIdNot(String rollNo, Long id) {
        return studentRepository.existsByRollNoAndIdNot(rollNo, id);
    }

    public boolean containsNumbers(String input) {
        return input != null && input.matches(".*\\d.*");
    }

    public boolean checkValidRollNo(long domainId, int admissionYear, String rollNo) {
        String str = "";
        String cpyRollNo = rollNo;
        if (domainId == 1)
            str = "MTCSE";
        else if (domainId == 2)
            str = "MTECE";
        else if (domainId == 3)
            str = "IMTCSE";
        else
            str = "IMTECE";
        String domainPlusAdmissionYear = str.concat(Integer.toString(admissionYear));
        String strReplace = cpyRollNo.replace(domainPlusAdmissionYear, "");

        return rollNo.startsWith(domainPlusAdmissionYear) && strReplace.matches("-?\\d+(\\.\\d+)?");
    }

    public ResponseEntity<?> updateStudent(Student newStudent, long id) {
        Optional<Student> student = findById(id);
        student.get().setFirst_name(newStudent.getFirst_name());
        student.get().setLast_name(newStudent.getLast_name());
        student.get().setEmail(newStudent.getEmail());
        student.get().setCgpa(newStudent.getCgpa());
        student.get().setAddress(newStudent.getAddress());
        student.get().setRollNo(newStudent.getRollNo());
        student.get().setAdmissionYear(newStudent.getAdmissionYear());
        student.get().setGraduation_year(newStudent.getGraduation_year());
        student.get().setDomain(newStudent.getDomain());
        student.get().setPhotograph_path(newStudent.getPhotograph_path());
        student.get().setTotalCredits(newStudent.getTotalCredits());
        student.get().setSpecialization(newStudent.getSpecialization());

        if (!checkValidRollNo(student.get().getDomain().getId(), student.get().getAdmissionYear(), student.get().getRollNo()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Roll Number.");

        if (student.get().getFirst_name().length() == 0 || student.get().getLast_name().length() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name should not be NULL.");

        if (student.get().getFirst_name().contains(" ") || student.get().getLast_name().contains(" "))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name should not contain space.");

        if (student.get().getEmail().contains(" "))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email should not contain space.");

        if (student.get().getEmail().length() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email should not be NULL.");

        int currentCapacity = countByDomainId(student.get().getDomain().getId());
        if (currentCapacity >= student.get().getDomain().getCapacity()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Domain is having full capacity.");
        }
        if (existsByEmailAndIdNot(student.get().getEmail(), id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists in the database.");
        }
        else if (existsByRollNoAndIdNot(student.get().getRollNo(), id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Roll Number already exists in the database.");
        }
        else if (containsNumbers(student.get().getFirst_name()) || containsNumbers(student.get().getLast_name())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name should not contain digits.");
        } else if (student.get().getSpecialization().getCreditsRequired() > student.get().getTotalCredits())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student does not have the required credits for the specialization.");
        else
            save(student.orElse(null));
        return ResponseEntity.ok("Student Updated");
    }
}