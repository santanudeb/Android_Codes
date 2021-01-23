package com.code.databaseapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DisplayActivity extends AppCompatActivity {

    Button dbtn;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_layout);

        dbtn=(Button) findViewById(R.id.displayallbtn);
        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openOrCreateDatabase("mydatabase.db", Context.MODE_PRIVATE,null);
                //rawQuery returns collection of data and storing it on Cursor type variable
                Cursor c=db.rawQuery("Select name,email from tblregistration",null);
                StringBuilder sb=new StringBuilder(); //StringBuilder

                while (c.moveToNext()) //moveToNext() return true or false, if true then place the cursor on particular row
                {
                    String nm=c.getString(0); //name
                    String em=c.getString(1); //email
                    sb.append("Name: "+nm+"\nEmail: "+em+"\n\n");  //Fetching data from database
                }

                showMessage("User Details",sb.toString());  //(title,StringBuilder) show alert dialog box
            }
        });
    }

    public void showMessage(String ti,String msg)
    {
        ////AlertDialog(contains a title box and a mes box) for showing something
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setTitle(ti); //title
        b.setMessage(msg); //msg
        b.setCancelable(true);
        b.show();
    }
}

//StringBuffer
//StringBuilder