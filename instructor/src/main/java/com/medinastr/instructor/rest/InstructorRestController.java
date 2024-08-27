package com.medinastr.instructor.rest;

import com.medinastr.instructor.dto.CourseDTO;
import com.medinastr.instructor.dto.InstructorCourseDTO;
import com.medinastr.instructor.dto.InstructorAndStudentDTO;
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
    public ResponseEntity<Instructor> saveWithDetails(@RequestBody InstructorDetailDTO instructorDetailDTO) {
        Instructor dbInstructor = instructorService.saveWithDetails(instructorDetailDTO);
        return ResponseEntity.status(201).body(dbInstructor);
    }

    @PostMapping("/courses")
    public ResponseEntity<Instructor> saveWithCourses(@RequestBody InstructorCourseDTO instructorCourseDTO) {
        Instructor dbInstructor = instructorService.saveWithCourses(instructorCourseDTO);
        return ResponseEntity.status(201).body(dbInstructor);
    }

    // GET for getting Instructor list without InstructorDetail and Course
    @GetMapping
    public ResponseEntity<List<InstructorAndStudentDTO>> getInstructorsList() {
        List<InstructorAndStudentDTO> instructors = instructorService.getInstructorsList();
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

    @GetMapping("{id}/courses")
    public ResponseEntity<List<CourseDTO>> instructorCourses(@PathVariable int id) {
        Optional<Instructor> instructor = instructorService.getInstructor(id);
        if(instructor.isPresent()) {
            List<CourseDTO> courses = instructorService.instructorCourses(instructor.get());
            return ResponseEntity.status(200).body(courses);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody InstructorAndStudentDTO instructorAndStudentDTO) {
        Optional<Instructor> dbInstructor = instructorService.update(id, instructorAndStudentDTO);
        if(dbInstructor.isPresent()) {
            return ResponseEntity.status(201).body("Successfully updated!");
        } else {
            return ResponseEntity.status(404).body("Instructor not found: " + id);
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
