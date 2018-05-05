package com.example.roman.myretrofitexample.data.managers;

import android.content.Context;

import com.example.roman.myretrofitexample.utils.App;


public class DataManager {
    private static DataManager INSTANCE = null;
    private Context mContext;
    private PreferencesManager mPreferencesManager;

    public DataManager(){
        this.mPreferencesManager = new PreferencesManager();
        this.mContext = App.getContext();
    }

    public static DataManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public PreferencesManager getPreferencesManager() {
        return mPreferencesManager;
    }

    public Context getContext(){
        return mContext;
    }
}