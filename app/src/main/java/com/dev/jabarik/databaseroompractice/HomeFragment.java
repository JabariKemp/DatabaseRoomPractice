package com.dev.jabarik.databaseroompractice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button btnAddUser, btnReadUsers, btnDeleteUser;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnAddUser = view.findViewById(R.id.btn_add_user);
        btnAddUser.setOnClickListener(this);
        btnReadUsers = view.findViewById(R.id.btn_view_user);
        btnReadUsers.setOnClickListener(this);
        btnDeleteUser = view.findViewById(R.id.btn_delete_user);
        btnDeleteUser.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btn_add_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_main_activity, new AddUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.btn_view_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_main_activity, new ReadUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.btn_delete_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_main_activity, new DeleteUserFragment()).addToBackStack(null).commit();
                break;
        }

    }
}
