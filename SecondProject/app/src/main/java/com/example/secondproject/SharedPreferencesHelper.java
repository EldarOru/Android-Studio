package com.example.secondproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;

public class SharedPreferencesHelper {
    public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    public static final String SEARCH_KEY = "SEARCH_KEY";
    private SharedPreferences mSharedPreferences;

    public SharedPreferencesHelper(Context context){
        mSharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
    }

    public void saveSettings(String choice){
        mSharedPreferences.edit().putString(SEARCH_KEY,choice).apply();
    }
    public String loadSettings(){
        return mSharedPreferences.getString(SEARCH_KEY,"https://www.google.com/search?q=");
    }
}
