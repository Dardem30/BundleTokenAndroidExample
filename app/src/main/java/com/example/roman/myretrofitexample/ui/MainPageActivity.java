package com.example.roman.myretrofitexample.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.roman.myretrofitexample.data.managers.DataManager;
import com.example.roman.myretrofitexample.data.network.Link;
import com.example.roman.myretrofitexample.R;
import com.example.roman.myretrofitexample.data.network.ServiceGenerator;
import com.example.roman.myretrofitexample.model.UserDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainPageActivity extends AppCompatActivity {
    private Link link= ServiceGenerator.createService(Link.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    public void getPassword(View view) {
        System.out.println(getIntent().getSerializableExtra("username"));
        Bundle bundle=getIntent().getExtras();
        Call<UserDto> call=link.userByUsername(bundle.getString("username"));
        call.enqueue(new Callback<UserDto>() {
            @Override
            public void onResponse(Call<UserDto> call, Response<UserDto> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainPageActivity.this, response.body().password, Toast.LENGTH_LONG).show();
                    Toast.makeText(MainPageActivity.this, "aeeeeeeeeeeeeeeeeeeeeee", Toast.LENGTH_LONG).show();
                    System.out.println(response.body().password);
                    System.out.println("aeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                }else{
                    System.out.println(response.isSuccessful());
                    System.out.println(response.errorBody());
                    System.out.println(response.message());
                    System.out.println(response.code());
                    System.out.println(response.raw());
                }
            }

            @Override
            public void onFailure(Call<UserDto> call, Throwable t) {

            }
        });
    }
}
