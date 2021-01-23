package com.code.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    EditText delr;
    Button dbtn;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_layout);
        //
        delr=(EditText)findViewById(R.id.del_Roll);
        dbtn=(Button)findViewById(R.id.del_Btn);
        db=openOrCreateDatabase("mydatabase.db", Context.MODE_PRIVATE,null);

        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(delr.getText().toString().trim().length()>0) //trim() removes the space given in input
                {
                    int r = Integer.parseInt(delr.getText().toString().trim());
                    if(r>0)
                    {
                        Cursor c=db.rawQuery("select * from tblregistration where roll="+r,null); //finding roll
                        if(c.moveToFirst()) {
                            db.execSQL("delete from tblregistration where roll="+r); //deleting
                            delr.setText(""); //blank
                            Toast.makeText(DeleteActivity.this, "Deleted data successfully!!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(DeleteActivity.this,"No such registered roll no!!",Toast.LENGTH_LONG).show();
                        }

                    }
                    else
                    {
                        Toast.makeText(DeleteActivity.this,"Roll number should be a positive number",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(DeleteActivity.this,"Enter roll number",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
