package com.androidapp.mcs.student_info_room;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ReadDataFragment extends Fragment {


 private TextView txtInfo;
    public ReadDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_data, container, false);
        txtInfo = view.findViewById(R.id.textView);


        List<User> student = MainActivity.myAppDatabase.myDao().getUsers();
        String info = "";
        for (User students: student)
        {
            int rollNumber = students.getRollNo();
            String name = students.getName();


            info = info+"\n"+"STUDENT NAME:"+name+"\n"+"STUDENT ROLL NO:"+rollNumber+"\n\n";
        }

        txtInfo.setText(info);
        return view;

    }


}
