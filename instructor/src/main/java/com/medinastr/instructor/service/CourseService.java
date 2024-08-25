package com.medinastr.instructor.service;

import com.medinastr.instructor.dao.CourseRepository;
import com.medinastr.instructor.dto.CourseDTO;
import com.medinastr.instructor.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // for GET mapping -> "/courses" will get all the courses
    public List<CourseDTO> getCoursesList() {
        List<Course> courses = courseRepository.findAll();

        return courses.stream()
                .map(course -> new CourseDTO(course.getId(), course.getTitle(), course.getInstructor().getId()))
                .collect(Collectors.toList());
    }
}
