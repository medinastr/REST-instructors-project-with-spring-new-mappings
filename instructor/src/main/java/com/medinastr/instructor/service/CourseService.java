package com.medinastr.instructor.service;

import com.medinastr.instructor.dao.CourseRepository;
import com.medinastr.instructor.dao.InstructorRepository;
import com.medinastr.instructor.dto.CourseDTO;
import com.medinastr.instructor.entity.Course;
import com.medinastr.instructor.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    CourseRepository courseRepository;
    InstructorRepository instructorRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    // for POST
    public Course save(CourseDTO courseDTO) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(courseDTO.getInstructor_id());

        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setInstructor(optionalInstructor.get());

        Course dbCourse = courseRepository.save(course);

        return dbCourse;
    }

    // for GET mapping -> "/courses" will get all the courses
    public List<CourseDTO> getCoursesList() {
        List<Course> courses = courseRepository.findAll();

        return courses.stream()
                .map(course -> new CourseDTO(course.getTitle(), course.getInstructor().getId()))
                .collect(Collectors.toList());
    }
}
