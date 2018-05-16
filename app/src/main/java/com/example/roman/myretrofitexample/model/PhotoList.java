package com.example.roman.myretrofitexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Roman on 14.05.2018.
 */

public class PhotoList {
    @SerializedName("data")
    private List<Photos> photosList;

    public List<Photos> getPhotosList() {
        return photosList;
    }

    public void setPhotosList(List<Photos> photosList) {
        this.photosList = photosList;
    }
}
