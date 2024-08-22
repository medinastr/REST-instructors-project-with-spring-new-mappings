package com.medinastr.instructor.rest;

import com.medinastr.instructor.dto.InstructorCourseDTO;
import com.medinastr.instructor.dto.InstructorDTO;
import com.medinastr.instructor.dto.InstructorDetailDTO;
import com.medinastr.instructor.entity.Instructor;
import com.medinastr.instructor.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instructors")
public class InstructorRestController {

    InstructorService instructorService;

    @Autowired
    public InstructorRestController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/details")
    public ResponseEntity<Instructor> save(@RequestBody InstructorDetailDTO instructorDetailDTO) {
        Instructor dbInstructor = instructorService.save(instructorDetailDTO);
        return ResponseEntity.status(201).body(dbInstructor);
    }

    @PostMapping("/courses")
    public ResponseEntity<Instructor> saveWithCourses(@RequestBody InstructorCourseDTO instructorCourseDTO) {
        Instructor dbInstructor = instructorService.saveWithCourses(instructorCourseDTO);
        return ResponseEntity.status(201).body(dbInstructor);
    }

    @GetMapping
    public ResponseEntity<List<InstructorDTO>> getInstructorsList() {
        List<InstructorDTO> instructors = instructorService.getInstructorsList();
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
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean checkDelete = instructorService.delete(id);
        if(checkDelete == true) {
            return ResponseEntity.status(204).body(null);
        } else {
            return ResponseEntity.status(404).body("Instructor not found: " + id);
        }
    }
}
