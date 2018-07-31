package com.dev.jabarik.databaseroompractice;


import android.arch.persistence.room.Delete;
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
public class DeleteUserFragment extends Fragment {

    EditText TxtUsrId;
    Button DeleteButton;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        TxtUsrId = view.findViewById(R.id.txt_delete_user_id);
        DeleteButton = view.findViewById(R.id.btn_delete_user_infrag);
        DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(TxtUsrId.getText().toString());
                User user = new User();
                user.setId(id);
                MainActivity.myAppDatabase.myDao().deleteUser(user);
                Toast.makeText(getActivity(), "User Deleted", Toast.LENGTH_SHORT).show();
                TxtUsrId.setText("");


            }
        });

        return view;
    }

}
