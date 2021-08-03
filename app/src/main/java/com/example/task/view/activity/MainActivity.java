package com.example.task.view.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.task.R;
import com.example.task.databinding.ActivityMainBinding;
import com.example.task.view.dialog.AddEventDialog;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    public NavController navController;

    private ImageView ivLanguage;



    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadLocale();
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host);

        navController = navHostFragment.getNavController();


        binding.ivLanguages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            showChangeLanguageDialoge();

            }
        });



    }

    private void showChangeLanguageDialoge() {
        final String[] listItemLang = {  "English","عربي"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Choose Language . . . ");
        mBuilder.setSingleChoiceItems(listItemLang, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==0){
                    setLocale("en");
                    recreate();


                }
                else if(which==1){
                    setLocale("ar");
                    recreate();

                }
                dialog.dismiss();
            }
        });
        AlertDialog mdialog=mBuilder.create();
        mdialog.show();
    }
    private void setLocale (String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale =locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();
    }

    public void loadLocale(){
        SharedPreferences prefer =getSharedPreferences("Settings" , Activity.MODE_PRIVATE);
        String language = prefer.getString("My_Lang","");
        setLocale(language);
    }

}

