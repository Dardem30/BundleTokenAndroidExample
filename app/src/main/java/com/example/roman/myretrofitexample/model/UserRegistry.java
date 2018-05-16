package com.example.roman.myretrofitexample.model;

/**
 * Created by Roman on 07.05.2018.
 */

public class UserRegistry {
    String username;
    String password;
    String name;
    String surname;
    String email;

    public UserRegistry(String username, String password, String name, String surname, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
