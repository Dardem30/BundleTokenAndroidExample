package com.example.roman.myretrofitexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
private Gson gson=new GsonBuilder().create();
private Retrofit retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl("http://10.0.2.2:8080")
        .build();
EditText password,username;
private Link link=retrofit.create(Link.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username =findViewById(R.id.username);
        password=findViewById(R.id.password);
    }

    public void login(View view) throws IOException {
        UserDto userDto=new UserDto(username.getText().toString(),password.getText().toString());
        Call<String> call=link.auth(userDto);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                if (response.isSuccess()){
                    Toast.makeText(MainActivity.this, response.body(), Toast.LENGTH_LONG).show();
                    Intent intent=new Intent("com.example.roman.myretrofitexample.MainPageActivity");
                    intent.putExtra("username",username.getText().toString());
                    intent.putExtra("token",response.headers().get("access-token"));
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, response.body(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(t.getLocalizedMessage());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }
}
