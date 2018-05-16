package com.example.roman.myretrofitexample.data.managers;

import android.content.SharedPreferences;

import com.example.roman.myretrofitexample.utils.App;


public class PreferencesManager {

    private SharedPreferences mSharedPreferences;


    public PreferencesManager() {
        this.mSharedPreferences= App.getSharedPreferences();
    }

    public void setAuthToken (String authToken){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("Token", authToken);
        editor.apply();
    }

    public String getAuthToken (){
        return mSharedPreferences.getString("Token", "null");
    }
    public void setUsername (String username){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("username", username);
        editor.apply();
    }

    public String getUsername (){
        return mSharedPreferences.getString("username", "null");
    }
    public void setUserId (int id){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("userId", String.valueOf(id));
        editor.apply();
    }

    public int getUserId (){
        return Integer.parseInt(mSharedPreferences.getString("userId", "null"));
    }


}
