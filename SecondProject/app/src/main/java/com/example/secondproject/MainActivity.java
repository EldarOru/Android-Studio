package com.example.secondproject;

import android.R;
import android.preference.PreferenceFragment;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment;
    SearchFragment searchFragment;
    OptionFragment optionFragment;
    FragmentTransaction fragmentTransaction;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (item.getItemId()) {
            case R.id.actionOption:
                fragmentTransaction.replace(R.id.fragmentContainer, optionFragment);
                showText(item.getTitle().toString());
                break;
            case R.id.actionSearch:
                fragmentTransaction.replace(R.id.fragmentContainer, searchFragment);
                showText(item.getTitle().toString());
                break;
            case R.id.actionExit:
                showText(item.getTitle().toString());
                finish();
                break;
            default:
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        return super.onOptionsItemSelected(item);
    }

    private void showText( String string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();
        searchFragment = new SearchFragment();
        optionFragment = new OptionFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer, mainFragment).commit();

    }
}


