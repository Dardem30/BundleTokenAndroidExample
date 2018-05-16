package com.example.roman.myretrofitexample.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.roman.myretrofitexample.R;
import com.example.roman.myretrofitexample.data.network.Link;
import com.example.roman.myretrofitexample.data.network.ServiceGenerator;
import com.example.roman.myretrofitexample.model.UserRegistry;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistryActivity extends AppCompatActivity {
EditText name,surname,username,password,email,url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        name=(EditText) findViewById(R.id.name);
        surname=(EditText) findViewById(R.id.surname);
        username=(EditText) findViewById(R.id.usernameReg);
        password=(EditText) findViewById(R.id.passwordReg);
        email=(EditText) findViewById(R.id.email);
        url=(EditText) findViewById(R.id.url);

    }

    public void signUp(View view) {
        final Link link=ServiceGenerator.createService(Link.class);
        Call<UserRegistry> call= link.signUp(new UserRegistry(username.getText().toString(),
                        password.getText().toString(),
                        name.getText().toString(),
                        surname.getText().toString(),
                        email.getText().toString()));
        call.enqueue(new Callback<UserRegistry>() {
            @Override
            public void onResponse(Call<UserRegistry> call, Response<UserRegistry> response) {
                if(response.isSuccessful()){
                    if(!url.getText().toString().equals("")){
                        Call<UserRegistry> callP= link.savePhoto(username.getText().toString(),url.getText().toString());
                        callP.enqueue(new Callback<UserRegistry>() {
                            @Override
                            public void onResponse(Call<UserRegistry> call, Response<UserRegistry> response) {
                                if(response.isSuccessful()){
                                    System.out.println("phhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
                                }else {
                                    System.out.println("fphhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
                                    System.out.println(response.code());
                                }
                            }

                            @Override
                            public void onFailure(Call<UserRegistry> call, Throwable t) {
                                System.out.println("tphhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");

                            }
                        });
                    }
                    Intent intent=new Intent(RegistryActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    System.out.println(response.code());
                }
            }

            @Override
            public void onFailure(Call<UserRegistry> call, Throwable t) {
                System.out.println(t.getCause());
            }
        });
    }
}
