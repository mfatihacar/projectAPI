package com.gorest.dto.users.response;

public class Data {
    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;
    private String created_at;
    private String updated_at;

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
