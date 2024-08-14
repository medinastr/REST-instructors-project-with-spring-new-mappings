package com.medinastr.instructor.rest;

import com.medinastr.instructor.dto.InstructorDTO;
import com.medinastr.instructor.entity.Instructor;
import com.medinastr.instructor.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorRestController {

    InstructorService instructorService;

    @Autowired
    public InstructorRestController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public ResponseEntity<Instructor> save(@RequestBody InstructorDTO instructorDTO) {
        Instructor dbInstructor = instructorService.save(instructorDTO);
        return ResponseEntity.status(201).body(dbInstructor);
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getInstructorsList() {
        List<Instructor> instructors = instructorService.getInstructorsList();
        return ResponseEntity.status(200).body(instructors);
    }
}
