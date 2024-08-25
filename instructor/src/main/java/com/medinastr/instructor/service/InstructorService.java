package com.medinastr.instructor.service;

import com.medinastr.instructor.dao.InstructorRepository;
import com.medinastr.instructor.dto.CourseDTO;
import com.medinastr.instructor.dto.InstructorCourseDTO;
import com.medinastr.instructor.dto.InstructorDTO;
import com.medinastr.instructor.dto.InstructorDetailDTO;
import com.medinastr.instructor.entity.Course;
import com.medinastr.instructor.entity.Instructor;
import com.medinastr.instructor.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstructorService {

    InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    // POST for "/instructors/details"
    public Instructor saveWithDetails(InstructorDetailDTO instructorDetailDTO) {
        Instructor dbInstructor = new Instructor();
        InstructorDetail dbInstructorDetail = new InstructorDetail();

        dbInstructorDetail.setYoutubeChannel(instructorDetailDTO.getYoutubeChannel()); // get yt channel
        dbInstructorDetail.setHobby(instructorDetailDTO.getHobby()); // get hobby

        dbInstructor.setFirstName(instructorDetailDTO.getFirstName()); // get first name
        dbInstructor.setLastName(instructorDetailDTO.getLastName()); // get last name
        dbInstructor.setEmail(instructorDetailDTO.getEmail()); // get email
        dbInstructor.setInstructorDetail(dbInstructorDetail); // save instructor detail

        Instructor savedInstructor = instructorRepository.save(dbInstructor);

        return savedInstructor;
    }

    // POST for "/instructors/courses"
    public Instructor saveWithCourses(InstructorCourseDTO instructorCourseDTO) {
        Instructor dbInstructor = new Instructor();
        InstructorDetail dbInstructorDetail = new InstructorDetail();
        Course dbCourse = new Course();

        dbCourse.setTitle(instructorCourseDTO.getTitle()); // get course title

        dbInstructorDetail.setYoutubeChannel(instructorCourseDTO.getYoutubeChannel()); // get yt channel
        dbInstructorDetail.setHobby(instructorCourseDTO.getHobby()); // get hobby

        dbInstructor.setFirstName(instructorCourseDTO.getFirstName()); // get firstName
        dbInstructor.setLastName(instructorCourseDTO.getLastName()); // get lastName
        dbInstructor.setEmail(instructorCourseDTO.getEmail()); // get email
        dbInstructor.addCourse(dbCourse); // get Course
        dbInstructor.setInstructorDetail(dbInstructorDetail); // get InstructorDetail

        Instructor savedInstructor = instructorRepository.save(dbInstructor);

        return savedInstructor;
    }

    // for GET mapping -> instructors list without details and courses
    public List<InstructorDTO> getInstructorsList() {
        List<Instructor> instructors = instructorRepository.findAll();
        return instructors.stream()
                .map(instructor -> new InstructorDTO(
                        instructor.getFirstName(), instructor.getLastName(), instructor.getEmail()))
                .collect(Collectors.toList());
    }

    // for GET mapping -> get one instructor
    public Optional<Instructor> getInstructor(int id) {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        return instructor;
    }

    // for GET mapping -> get courses of one instructor
    public List<CourseDTO> instructorCourses(Instructor instructor) {
        List<Course> courses = instructor.getCourses();
        return courses.stream()
                .map(course -> new CourseDTO(course.getTitle(), course.getInstructor().getId()))
                .collect(Collectors.toList());
    }

    public Optional<Instructor> update(int id, InstructorDTO instructorDTO) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(id);

        if(optionalInstructor.isPresent()) {
            Instructor instructor = optionalInstructor.get();
            instructor.setFirstName(instructorDTO.getFirstName());
            instructor.setLastName(instructorDTO.getLastName());
            instructor.setEmail(instructorDTO.getEmail());
            instructorRepository.save(instructor);
        }

        return optionalInstructor;
    }

    public boolean delete(int id) {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        if(instructor.isPresent()) {
            instructorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
