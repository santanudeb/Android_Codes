package com.code.fragmentexample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;



public class FirstFragment extends Fragment {

    View v; //variable of view class
    Button btn1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  //LayoutInflater inflating the layout
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //container view group //View used for generating layout
        v=inflater.inflate(R.layout.first_fragment_layout,container,false);  //initialise the view
        btn1=(Button)v.findViewById(R.id.btnfrag1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"First",Toast.LENGTH_LONG).show(); //Fragment is aa part of Activity
                //getActivity() because it will be callled from activity
            }
        });
        return v;
    }
}

//Fragment is a sub View of the activity where it has been used