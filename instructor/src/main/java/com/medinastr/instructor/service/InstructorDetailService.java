package com.medinastr.instructor.service;

import com.medinastr.instructor.dao.InstructorDetailRepository;
import com.medinastr.instructor.dao.InstructorRepository;
import com.medinastr.instructor.entity.Instructor;
import com.medinastr.instructor.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorDetailService {

    @Autowired
    private InstructorDetailRepository instructorDetailRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    public boolean deleteInstructorDetail(int id) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(id);

        if (instructorOptional.isPresent()) {
            Instructor instructor = instructorOptional.get();
            InstructorDetail instructorDetail = instructor.getInstructorDetail();

            if (instructorDetail != null) {
                instructor.setInstructorDetail(null);  // break the Instructor relationship with your detail
                instructorRepository.save(instructor);  // update the Instructor without detail
                instructorDetailRepository.delete(instructorDetail); // delete the InstructorDetail
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

