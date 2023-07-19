package com.gorest.dto.users.response;

public class UsersResponse {

    private int code;
    private Meta meta;
    private Data[] data;

    public int getCode() {
        return code;
    }

    public Meta getMeta() {
        return meta;
    }

    public Data[] getData() {
        return data;
    }
}
