package com.dev.jabarik.databaseroompractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<String> nameList;
    Context con;

    public CustomAdapter(ArrayList<String> n, Context context) {
        nameList = n;
        con = context;
    }


    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int i) {
        return nameList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(con).inflate(R.layout.list_view_layout,viewGroup,false );
        TextView textView = view.findViewById(R.id.list_view_text);
        textView.setText(nameList.get(i));
        ImageView imageView = view.findViewById(R.id.list_view_image);
        imageView.setImageResource(R.drawable.ic_launcher_background);
        return view;
    }
}
