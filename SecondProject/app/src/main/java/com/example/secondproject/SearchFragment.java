package com.example.secondproject;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;

public class SearchFragment extends Fragment {
    private String searcher;
    private Button button_search;
    private EditText editText;
    private SharedPreferencesHelper sharedPreferencesHelper;

    private Button.OnClickListener btnonclklisten = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(searcher+editText.getText().toString()));
            startActivity(intent);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_fragment,container,false);
        editText = v.findViewById(R.id.etText);
        button_search = v.findViewById(R.id.clickSearch);
        button_search.setOnClickListener(btnonclklisten);
        sharedPreferencesHelper = new SharedPreferencesHelper(getContext());
        searcher = sharedPreferencesHelper.loadSettings();
        return v;
    }
}
