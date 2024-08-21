package com.medinastr.instructor.rest;

import com.medinastr.instructor.service.InstructorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructors/details")
public class InstructorDetailRestController {

    @Autowired
    private InstructorDetailService instructorDetailService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstructorDetail(@PathVariable int id) {
        boolean checkDelete = instructorDetailService.deleteInstructorDetail(id);
        if(checkDelete == true) {
            return ResponseEntity.status(204).body(null);
        } else {
            return ResponseEntity.status(404).body("Instructor detail not found: " + id);
        }
    }
}
