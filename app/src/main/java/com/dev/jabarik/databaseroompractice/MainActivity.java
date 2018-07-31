package com.dev.jabarik.databaseroompractice;

import android.app.FragmentManager;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static android.support.v4.app.FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb").allowMainThreadQueries().build();


        if(findViewById(R.id.frame_main_activity) != null)
        {
            if(savedInstanceState != null)
            {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.frame_main_activity, new HomeFragment()).commit();

        }



    }
}
