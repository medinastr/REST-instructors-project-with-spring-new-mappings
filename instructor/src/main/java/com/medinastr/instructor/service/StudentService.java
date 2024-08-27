package com.medinastr.instructor.service;

import com.medinastr.instructor.dao.StudentRepository;
import com.medinastr.instructor.dto.InstructorAndStudentDTO;
import com.medinastr.instructor.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(InstructorAndStudentDTO instructorAndStudentDTO) {
        Student dbStudent = new Student();
        dbStudent.setFirstName(instructorAndStudentDTO.getFirstName());
        dbStudent.setLastName(instructorAndStudentDTO.getLastName());
        dbStudent.setEmail(instructorAndStudentDTO.getEmail());
        return studentRepository.save(dbStudent);
    }
}
