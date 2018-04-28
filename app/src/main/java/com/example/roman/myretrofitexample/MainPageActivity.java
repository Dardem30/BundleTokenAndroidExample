package com.example.roman.myretrofitexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainPageActivity extends AppCompatActivity {
    private Gson gson=new GsonBuilder().create();
    private Retrofit retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://10.0.2.2:8080")
            .build();
    private Link link=retrofit.create(Link.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        System.out.println(getIntent().getSerializableExtra("username"));
        Bundle bundle=getIntent().getExtras();
        Call<UserDto> call=link.userByUsername(bundle.getString("username"),bundle.getString("token"));
        call.enqueue(new Callback<UserDto>() {
            @Override
            public void onResponse(Response<UserDto> response, Retrofit retrofit) {
                if(response.isSuccess()){
                    Toast.makeText(MainPageActivity.this, response.body().password, Toast.LENGTH_LONG).show();
                    System.out.println(response.body().password);
                }else{
                    System.out.println(response.isSuccess());
                    System.out.println(response.errorBody());
                    System.out.println(response.message());
                    System.out.println(response.code());
                    System.out.println(response.raw());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(MainPageActivity.this, "error", Toast.LENGTH_LONG).show();
            }
        });
    }

}
