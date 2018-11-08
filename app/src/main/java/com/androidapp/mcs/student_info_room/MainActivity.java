package com.androidapp.mcs.student_info_room;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity

{

    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding fragment to main activity
        fragmentManager = getSupportFragmentManager();


        //Create database object
        myAppDatabase = Room.databaseBuilder(
                getApplicationContext(), MyAppDatabase.class, "studentdb").allowMainThreadQueries().build();


        //Check if the fragment instance is not null
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            //This adds HomeFragment to the Main activity
            fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();


        }

    }}
