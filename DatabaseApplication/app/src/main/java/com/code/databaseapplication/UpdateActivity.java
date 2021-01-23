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

public class UpdateActivity extends AppCompatActivity {

    EditText eroll,eemail;
    Button ebtn;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_layout);
        //
        eroll=(EditText)findViewById(R.id.text_roll);
        eemail=(EditText)findViewById(R.id.text_email);
        ebtn=(Button)findViewById(R.id.btn_update);

        ebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int r=Integer.parseInt(eroll.getText().toString());
                String nem=eemail.getText().toString();
                db=openOrCreateDatabase("mydatabase.db", Context.MODE_PRIVATE,null);
                Cursor c=db.rawQuery("select * from tblregistration where roll="+r,null);
                if(c.moveToFirst()){
                    //db.execSQL("update tblregistration set email='"+nem+"' where roll="+r,null);
                    db.execSQL("update tblregistration set email='"+nem+"' where roll="+r);
                    Toast.makeText(UpdateActivity.this, "Data Updated Successfully", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(UpdateActivity.this,"No Such Roll Number",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
