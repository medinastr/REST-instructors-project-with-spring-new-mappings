package com.medinastr.instructor.rest;

import com.medinastr.instructor.dto.InstructorAndStudentDTO;
import com.medinastr.instructor.entity.Student;
import com.medinastr.instructor.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody InstructorAndStudentDTO instructorAndStudentDTO) {
        Student dbStudent = studentService.save(instructorAndStudentDTO);
        return ResponseEntity.status(201).body(dbStudent);
    }
}
