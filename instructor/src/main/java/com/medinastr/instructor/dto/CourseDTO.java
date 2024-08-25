package com.medinastr.instructor.dto;

public class CourseDTO {

    private String title;
    private int instructor_id;

    public CourseDTO() {}

    public CourseDTO(String title, int instructor_id) {
        this.title = title;
        this.instructor_id = instructor_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
    }
}
