package com.dev.jabarik.databaseroompractice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    private TextView TxtInfo;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);

        TxtInfo = view.findViewById(R.id.txt_read_user);
        List<User> usersInfo = MainActivity.myAppDatabase.myDao().getUsers();
        String info = "";

        for(User usr : usersInfo)
        {
            int usrid = usr.getId();
            String usrname = usr.getName();
            String usremail = usr.getEmail();
            info = info +"\n\n"+ "ID: "+ usrid + " NAME: "+ usrname + " EMAIL: "+ usremail;
        }

        TxtInfo.setText(info);
        return view;
    }

}
