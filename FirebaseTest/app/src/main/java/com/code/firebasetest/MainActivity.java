package com.code.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText txtname, txtage, txtphone, txtheight;
    Button btnsave ,btnnext;
    DatabaseReference reff;
    Member member;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtname=(EditText)findViewById(R.id.txtname);
        txtage=(EditText)findViewById(R.id.txtage);
        txtphone=(EditText)findViewById(R.id.txtphone);
        txtheight=(EditText)findViewById(R.id.txtheight);
        btnsave=(Button)findViewById(R.id.btnsave);
        btnnext=(Button)findViewById(R.id.btnNext);

        member=new Member();
        reff=FirebaseDatabase.getInstance().getReference().child("Member");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid=(dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age=Integer.parseInt(txtage.getText().toString().trim());
                Float height=Float.parseFloat((txtheight.getText().toString().trim()));
                Long phone=Long.parseLong(txtphone.getText().toString().trim());

                member.setName(txtname.getText().toString().trim());
                member.setAge(age);
                member.setHeight(height);
                member.setPhone(phone);

                //reff.push().setValue(member);
                //for edit
                //reff.child("member1").setValue(member);
                //reff.child(String.valueOf(maxid+1)).setValue(member);
                reff.child(String.valueOf(phone)).setValue(member);
                Toast.makeText(MainActivity.this, "successfully", Toast.LENGTH_LONG).show();
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ShowDataActivity.class);
                startActivity(i);
            }
        });

    }
}
