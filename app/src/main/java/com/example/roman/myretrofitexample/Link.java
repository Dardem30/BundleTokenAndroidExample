package com.example.roman.myretrofitexample;

import android.support.v4.media.AudioAttributesCompat;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Roman on 27.04.2018.
 */

public interface Link {
    @POST("auth")
    Call<String> auth(@Body UserDto userDto);
    @GET("usersByUsername/{username}")
    Call<UserDto> userByUsername(@Path("username")String username,@Header("Token")String token);
}
