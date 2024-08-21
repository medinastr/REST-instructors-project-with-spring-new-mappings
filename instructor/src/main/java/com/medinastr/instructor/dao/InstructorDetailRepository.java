package com.medinastr.instructor.dao;

import com.medinastr.instructor.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {
}
