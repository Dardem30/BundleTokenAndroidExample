package com.example.roman.myretrofitexample;

import android.support.v4.media.AudioAttributesCompat;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by Roman on 27.04.2018.
 */

public interface Link {
    @POST("auth")
    Call<String> auth(@Body UserDto userDto);
    @GET("usersByUsername/{username}")
    Call<UserDto> userByUsername(@Path("username")String username);
}
