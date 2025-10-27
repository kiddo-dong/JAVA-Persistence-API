package com.example.User_Order_CRUD.user.domain;

public class UserRequestDto {
    private String name;

    public UserRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
