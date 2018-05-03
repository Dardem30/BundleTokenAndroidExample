package com.example.roman.myretrofitexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {
private Gson gson=new GsonBuilder().create();
EditText password,username;
private Link link= ServiceGenerator.createService(Link.class);
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
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.body(), Toast.LENGTH_LONG).show();
                    DataManager.getInstance().getPreferencesManager().setAuthToken(response.headers().get("access-token"));
                    Intent intent=new Intent("com.example.roman.myretrofitexample.MainPageActivity");
                    intent.putExtra("username",username.getText().toString());
                    intent.putExtra("token",response.headers().get("access-token"));
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, response.body(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(t.getMessage());
                System.out.println(t.getLocalizedMessage());
                System.out.println(t.getCause());
            }
        });
    }
}
