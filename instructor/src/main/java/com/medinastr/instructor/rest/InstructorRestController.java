package com.medinastr.instructor.rest;

import com.medinastr.instructor.dto.InstructorDTO;
import com.medinastr.instructor.entity.Instructor;
import com.medinastr.instructor.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructors")
public class InstructorRestController {

    InstructorService instructorService;

    @Autowired
    public InstructorRestController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public Instructor save(@RequestBody InstructorDTO instructorDTO) {
        Instructor dbInstructor = instructorService.save(instructorDTO);
        return dbInstructor;
    }
}
