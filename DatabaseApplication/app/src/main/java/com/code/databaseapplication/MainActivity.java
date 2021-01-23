package com.code.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText r_roll,r_name,r_email,r_password;
    Button r_btn;
    SQLiteDatabase db; //SQLiteDatabase class sql for database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r_roll=(EditText)findViewById(R.id.reg_roll);
        r_name=(EditText)findViewById(R.id.reg_name);
        r_email=(EditText)findViewById(R.id.reg_email);
        r_password=(EditText)findViewById(R.id.reg_password);
        r_btn=(Button)findViewById(R.id.reg_btn);

        //openOrCreateDatabase will open database if exist or create if doesn't.
        //("database name.db", Mode, null wil not return any value while creating or opening database.)
        db=openOrCreateDatabase("mydatabase.db", Context.MODE_PRIVATE,null);
        //creating table named tblregistration(column)
        db.execSQL("create table if not exists tblregistration(roll int, name varchar(20), email varchar(100), pswd varchar(20))");
        r_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int r=Integer.parseInt(r_roll.getText().toString()); //retrieving roll
                String nm=r_name.getText().toString();
                String em=r_email.getText().toString();
                String ps=r_password.getText().toString();
                //inserting into table named tblregistration ("+int+",'"+string+"','"+string+"','"+string+"')
                db.execSQL("insert into tblregistration values("+r+",'"+nm+"','"+em+"','"+ps+"')"); //append
                Toast.makeText(MainActivity.this,"Registered",Toast.LENGTH_LONG).show();
                Intent i=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });


    }

    //
    public void toLogin(View v)
    {
        Intent i=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);
    }
}
