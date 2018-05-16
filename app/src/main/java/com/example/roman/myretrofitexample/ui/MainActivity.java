package com.example.roman.myretrofitexample.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roman.myretrofitexample.data.managers.DataManager;
import com.example.roman.myretrofitexample.data.managers.PreferencesManager;
import com.example.roman.myretrofitexample.data.network.Link;
import com.example.roman.myretrofitexample.R;
import com.example.roman.myretrofitexample.data.network.ServiceGenerator;
import com.example.roman.myretrofitexample.model.User;
import com.example.roman.myretrofitexample.model.UserDto;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {
EditText password,username;
PreferencesManager preferencesManager=DataManager.getInstance().getPreferencesManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username =findViewById(R.id.username);
        password=findViewById(R.id.password);
    }

    public void login(View view) throws IOException {
        UserDto userDto=new UserDto(username.getText().toString(),password.getText().toString());
        Call<String> call= ServiceGenerator.createService(Link.class).auth(userDto);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "successful", Toast.LENGTH_LONG).show();
                    preferencesManager.setAuthToken(response.headers().get("access-token"));
                    preferencesManager.setUsername(username.getText().toString());
//                    preferencesManager.setUserId(response.body().getId());
                    Intent intent=new Intent("com.example.roman.myretrofitexample.ui.MainPageActivity");
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "successful", Toast.LENGTH_LONG).show();
                    System.out.println(response.code());
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

    public void toSignUp(View view) {
        Intent intent=new Intent(this,RegistryActivity.class);
        startActivity(intent);
    }
}
