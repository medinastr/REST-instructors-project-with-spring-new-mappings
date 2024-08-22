package com.medinastr.instructor.dao;

import com.medinastr.instructor.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
