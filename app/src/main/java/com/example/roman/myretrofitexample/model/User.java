package com.example.roman.myretrofitexample.model;


import java.util.Date;
import java.util.List;


public class User {
    Integer id;
    String username;
    String name;
    String surname;
    String password;
    String email;
    Date date;
    List<Photos> photos;

    public User() {
    }

    public User(Integer id, String username, String password, String name, String surname, String email, Date date, List<Photos> photos) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.date = date;
        this.photos = photos;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public Date getDate() {
        return date;
    }

    public List<Photos> getPhotos() {
        return photos;
    }
}