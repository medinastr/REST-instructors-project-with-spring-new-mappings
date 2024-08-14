package com.medinastr.instructor.service;

import com.medinastr.instructor.dao.InstructorRepository;
import com.medinastr.instructor.dto.InstructorDTO;
import com.medinastr.instructor.entity.Instructor;
import com.medinastr.instructor.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public Instructor save(InstructorDTO instructorDTO) {
        Instructor dbInstructor = new Instructor();
        InstructorDetail dbInstructorDetail = new InstructorDetail();

        dbInstructorDetail.setYoutubeChannel(instructorDTO.getYoutubeChannel()); // get yt channel
        dbInstructorDetail.setHobby(instructorDTO.getHobby()); // get hobby

        dbInstructor.setFirstName(instructorDTO.getFirstName()); // get first name
        dbInstructor.setLastName(instructorDTO.getLastName()); // get last name
        dbInstructor.setEmail(instructorDTO.getEmail()); // get email
        dbInstructor.setInstructorDetail(dbInstructorDetail); // save instructor detail

        System.out.println(dbInstructor.getFirstName());

        Instructor savedInstructor = instructorRepository.save(dbInstructor);

        return savedInstructor;
    }

    public List<Instructor> getInstructorsList() {
        List<Instructor> instructors = instructorRepository.findAll();
        return instructors;
    }

    public Optional<Instructor> getInstructor(int id) {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        return instructor;
    }
}
