package com.dev.jabarik.databaseroompractice;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    ArrayAdapter adapter;
    ArrayList<String> n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);

        String[] names = {"Jabari", "Charles", "Kemp"};
        n = new ArrayList<>();
        for(String a: names){
            n.add(a);
        }

        CustomAdapter adapter = new CustomAdapter(n, getApplicationContext());
        listView.setAdapter(adapter);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();



    }
}
