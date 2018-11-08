package com.androidapp.mcs.student_info_room;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.androidapp.mcs.student_info_room.MainActivity.fragmentManager;


public class HomeFragment extends Fragment {


    private EditText name, rollNo;
    private Button onDisplay, onSave;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        name = view.findViewById(R.id.edit_text1);
        rollNo = view.findViewById(R.id.edit_text2);

        onDisplay = view.findViewById(R.id.display_button);
        onSave = view.findViewById(R.id.save_button);


        onSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int rN = Integer.parseInt(rollNo.getText().toString());
                String userName = name.getText().toString();

                //Create object of entity class
                User user = new User();
                user.setName(userName);
                user.setRollNo(rN);


                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(), "Student added successfully!", Toast.LENGTH_SHORT).show();

                name.setText("");
                rollNo.setText("");
            }
        });
        onDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadDataFragment()).commit();
            }
        });

        return view;


    }
}