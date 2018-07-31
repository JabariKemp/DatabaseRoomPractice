package com.dev.jabarik.databaseroompractice;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText UserId, UserName, UserEmail;
    private Button BtnSave;
    User user;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        UserId = view.findViewById(R.id.txt_user_id);
        UserName = view.findViewById(R.id.txt_name);
        UserEmail = view.findViewById(R.id.txt_email);
        BtnSave = view.findViewById(R.id.btn_save);

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userid = Integer.parseInt(UserId.getText().toString());
                String username = UserName.getText().toString();
                String useremail = UserEmail.getText().toString();

                user = new User();
                user.setId(userid);
                user.setName(username);
                user.setEmail(useremail);


                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.myAppDatabase.myDao().addUser(user);
                    }
                });
                Toast.makeText(getActivity(), "User Added", Toast.LENGTH_SHORT).show();

                UserId.setText("");
                UserName.setText("");
                UserEmail.setText("");
            }
        });

        return view;
    }

}
