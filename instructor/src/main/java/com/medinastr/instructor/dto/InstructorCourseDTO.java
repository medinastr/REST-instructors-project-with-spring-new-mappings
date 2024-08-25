package com.medinastr.instructor.dto;

public class InstructorCourseDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String youtubeChannel;
    private String hobby;
    private String title;

    public InstructorCourseDTO() {}

    public InstructorCourseDTO(String firstName, String lastName, String email, String youtubeChannel, String hobby, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
