package com.medinastr.instructor.dto;

public class InstructorDetailDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String youtubeChannel;
    private String hobby;

    public InstructorDetailDTO(String firstName, String lastName, String email, String youtubeChannel, String hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
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
}
