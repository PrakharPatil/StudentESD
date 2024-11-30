package com.prakharpatil.studentesd.Controller;


import com.prakharpatil.studentesd.Model.Student;
import com.prakharpatil.studentesd.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(originPatterns = "http://localhost:*")
@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/exist")
    public ResponseEntity<?> exist(@RequestBody Student student) {
        long id = student.getId();
        if (studentService.existsById(id)) {
            return ResponseEntity.ok("ID Found");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("ID Not Found");
        }
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable long id) {
        Optional<Student> student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student newStudent, @PathVariable long id) {
        return studentService.updateStudent(newStudent, id);
    }
}