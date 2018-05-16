package com.example.roman.myretrofitexample.model;

/**
 * Created by Roman on 07.05.2018.
 */

public class Photos {
    int id;
    byte[] content;
    Integer userId;
    boolean ismain;

    public Photos(int id, byte[] content, Integer userId, boolean ismain) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.ismain = ismain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isIsmain() {
        return ismain;
    }

    public void setIsmain(boolean ismain) {
        this.ismain = ismain;
    }
}
