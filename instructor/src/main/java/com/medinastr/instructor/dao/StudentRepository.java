package com.medinastr.instructor.dao;

import com.medinastr.instructor.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
