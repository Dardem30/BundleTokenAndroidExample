package com.example.roman.myretrofitexample.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.roman.myretrofitexample.data.managers.DataManager;
import com.example.roman.myretrofitexample.data.network.Link;
import com.example.roman.myretrofitexample.R;
import com.example.roman.myretrofitexample.data.network.ServiceGenerator;
import com.example.roman.myretrofitexample.model.PhotoList;
import com.example.roman.myretrofitexample.model.Photos;
import com.example.roman.myretrofitexample.model.User;
import com.example.roman.myretrofitexample.model.UserDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainPageActivity extends AppCompatActivity {
    private Link link= ServiceGenerator.createService(Link.class);
    ImageView imageView;
    String username=DataManager.getInstance().getPreferencesManager().getUsername();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        imageView=(ImageView) findViewById(R.id.mainImg);
        Call<User> call=link.userByUsername(username);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    System.out.println("success");

                }else{
                    System.out.println(response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println(t.getCause());
            }
        });
        link.getMainPhoto(21)
                .enqueue(new Callback<PhotoList>() {
                    @Override
                    public void onResponse(Call<PhotoList> call, Response<PhotoList> response) {
                        if(response.isSuccessful()) {
                            System.out.println("rsssssssss");
                            byte[] byteArray=null;
                            for(Photos photos: response.body().getPhotosList()) {
                                if(photos.isIsmain()==true) {
                                    byteArray = photos.getContent();
                                }
                            }
                            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                            imageView.setImageBitmap(Bitmap.createScaledBitmap(bmp, imageView.getWidth(),
                                    imageView.getHeight(), false));
                        }else {
                            System.out.println("rffffffff");
                            System.out.println(response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<PhotoList> call, Throwable t) {
                        System.out.println("rtttttttttttt");
                        System.out.println(t.getMessage());
                        System.out.println(call.request().body());
                        System.out.println(t.getCause().getLocalizedMessage());
                    }
                });
    }

    public void getPassword(View view) {
    }
}
