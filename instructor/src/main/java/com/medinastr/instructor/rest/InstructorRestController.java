package com.medinastr.instructor.rest;

import com.medinastr.instructor.dto.InstructorDTO;
import com.medinastr.instructor.entity.Instructor;
import com.medinastr.instructor.service.InstructorService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable int id) {
        Optional<Instructor> instructor = instructorService.getInstructor(id);
        if(instructor.isPresent()) {
            return ResponseEntity.status(200).body(instructor.get());
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Instructor> delete(@PathVariable int id) {
        Instructor instructor = instructorService.delete(id);
        return ResponseEntity.status(204).body(instructor);
    }
}
