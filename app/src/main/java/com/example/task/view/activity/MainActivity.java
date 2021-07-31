package com.example.task.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.example.task.R;
import com.example.task.view.dialog.AddEventDialog;


public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    public NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host);

        navController = navHostFragment.getNavController();


       new AddEventDialog(this).show();

    }
}

//        Executors.newSingleThreadExecutor().execute(() -> {
//
//            DatabaseClient.getInstance(this)
//                    .getAppDatabase().eventDao().insert(new Event());
//        });