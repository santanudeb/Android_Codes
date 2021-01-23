package com.code.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SecondActivity extends AppCompatActivity {

    EditText ename;
    RadioGroup rggender,rgcity; //RadioGroup is for multiple button check option
    RadioButton r_male,r_female,r_kolkata,r_mumbai,r_bangalore,r_pune;
    Button bt_s;
    String gen="";
    String city="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        ename=(EditText)findViewById(R.id.text_name);
        rggender=(RadioGroup)findViewById(R.id.rg_gender);
        r_male=(RadioButton)findViewById(R.id.rd_male);
        r_female=(RadioButton)findViewById(R.id.rd_female);
        bt_s=(Button)findViewById(R.id.btn_welcome);
        rgcity=(RadioGroup)findViewById((R.id.rg_city));
        r_kolkata=(RadioButton)findViewById(R.id.rd_kolkata);
        r_mumbai=(RadioButton)findViewById(R.id.rd_mumbai);
        r_bangalore=(RadioButton)findViewById(R.id.rd_bangalore);
        r_pune=(RadioButton)findViewById(R.id.rd_pune);

        //check changes
        rggender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (r_male.isChecked())
                {
                    gen="Male";
                }
                if (r_female.isChecked())
                {
                    gen="Female";
                }

            }
        });

        //
        rgcity.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (r_kolkata.isChecked())
                {
                    city="kolkata";
                }
                if (r_mumbai.isChecked())
                {
                    city="mumbai";
                }
                if (r_bangalore.isChecked())
                {
                    city="bangalore";
                }
                if (r_pune.isChecked())
                {
                    city="pune";
                }

            }
        });

        //
        bt_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b=new Bundle(); //object of b
                b.putString("n1",ename.getText().toString()); //getting input and converting it to string
                b.putString("n2",gen); //putString putting the value in bundle
                b.putString("n3",city);
                Intent i = new Intent(SecondActivity.this,ThirdActivity.class);
                i.putExtras(b); //putting bundle into intent
                startActivity(i);
            }
        });


    }
}

//Bundle is for sending data from one activity to another. ("key",value).