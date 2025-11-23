package com.example.JPA_Springboot.user.dto;

public class UserResponseDto {

    public UserResponseDto(String naem, int age) {
        this.naem = naem;
        this.age = age;
    }

    private String naem;
    private int age;

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}