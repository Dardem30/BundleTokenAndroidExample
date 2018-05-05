package com.example.roman.myretrofitexample.model;

/**
 * Created by Roman on 27.04.2018.
 */

public class UserDto {
    public String username;
    public String password;

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
