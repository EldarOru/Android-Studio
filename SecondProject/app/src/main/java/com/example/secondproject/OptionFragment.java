package com.example.secondproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class OptionFragment extends Fragment {
    SharedPreferencesHelper mSharedPreferencesHelper;

    RadioGroup radioGroup;
    RadioButton rbGoogle;
    RadioButton rbYandex;
    RadioButton rbBing;

    private RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.radio_google:{
                    mSharedPreferencesHelper.saveSettings("https://www.google.com/search?q=");
                    break;
                }
                case R.id.radio_yandex:{
                    mSharedPreferencesHelper.saveSettings("https://yandex.ru/search/?text=");
                    break;
                }
                case R.id.radio_bing:{
                    mSharedPreferencesHelper.saveSettings("https://www.bing.com/search?q=");
                    break;
                }
            }
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.option_fragment,container,false);
        radioGroup = view.findViewById(R.id.radioGroup);
        rbGoogle = view.findViewById(R.id.radio_google);
        rbYandex = view.findViewById(R.id.radio_yandex);
        rbBing = view.findViewById(R.id.radio_bing);
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        mSharedPreferencesHelper = new SharedPreferencesHelper(getContext());
        String searcher = mSharedPreferencesHelper.loadSettings();
        switch (searcher){
            case "https://www.google.com/search?q=":
                radioGroup.check(R.id.radio_google);
                break;
            case "https://yandex.ru/search/?text=":
                radioGroup.check(R.id.radio_yandex);
                break;
            case "https://www.bing.com/search?q=":
                radioGroup.check(R.id.radio_bing);
                break;
        }
        return view;
    }

    }

