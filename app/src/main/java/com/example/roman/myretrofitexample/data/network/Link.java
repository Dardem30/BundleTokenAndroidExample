package com.example.roman.myretrofitexample.data.network;

import com.example.roman.myretrofitexample.model.PhotoList;
import com.example.roman.myretrofitexample.model.Photos;
import com.example.roman.myretrofitexample.model.User;
import com.example.roman.myretrofitexample.model.UserDto;
import com.example.roman.myretrofitexample.model.UserRegistry;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by Roman on 27.04.2018.
 */

public interface Link {
    @POST("auth")
    Call<String> auth(@Body UserDto userDto);

    @GET("usersByUsername/{username}")
    Call<User> userByUsername(@Path("username")String username);

    @POST("signUp")
    Call<UserRegistry> signUp(@Body UserRegistry userRegistry);

    @POST("photoAndroid/{username}")
    Call<UserRegistry> savePhoto(@Path("username") String username,@Body String url);

    @GET("userPhoto/{userId}")
    Call<PhotoList> getMainPhoto(@Path("userId") int userId);
}
