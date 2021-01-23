package com.code.firebasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    EditText etname, etphone;
    Button btnlogin;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        etname=(EditText)findViewById(R.id.etname);
        etphone=(EditText)findViewById(R.id.etphone);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        final String p=etphone.getText().toString();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff= FirebaseDatabase.getInstance().getReference().child("Member").child(p);
            }
        });
    }
}
