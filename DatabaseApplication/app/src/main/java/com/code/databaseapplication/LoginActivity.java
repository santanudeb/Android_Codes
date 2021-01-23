package com.code.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText log_email, log_password;
    Button log_btn;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        log_email=(EditText)findViewById(R.id.login_mail);
        log_password=(EditText)findViewById(R.id.login_password);
        log_btn=(Button)findViewById(R.id.login_btn);
        db=openOrCreateDatabase("mydatabase.db", Context.MODE_PRIVATE,null);
        log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em=log_email.getText().toString();
                String ps=log_password.getText().toString();
                //when a query returns value we use rawQuery
                Cursor c = db.rawQuery("select * from tblregistration where email='"+em+"' and pswd='"+ps+"'",null);
                //moveToFirst returns value if it exists in row or it doesn't return any if there is none or matched.
                if (c.moveToFirst())
                {
                    Toast.makeText(LoginActivity.this,"Successfull",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(LoginActivity.this,DashBoardActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Wrong User or Password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
