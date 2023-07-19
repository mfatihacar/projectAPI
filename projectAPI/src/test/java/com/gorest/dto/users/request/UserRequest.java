package com.gorest.dto.users.request;

public class UserRequest {

    private String name;
    private String gender;
    private String email;
    private String status;

    public static UserRequest newInstance(String name, String gender, String email, String status) {
        UserRequest userRequest = new UserRequest();
        userRequest.setName(name);
        userRequest.setGender(gender);
        userRequest.setEmail(email);
        userRequest.setStatus(status);
        return userRequest;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
