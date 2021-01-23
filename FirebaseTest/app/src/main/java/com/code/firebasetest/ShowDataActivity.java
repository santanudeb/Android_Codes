package com.code.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowDataActivity extends AppCompatActivity {

    TextView name, age, height, phone;
    EditText etenterphone, etentername;
    Button btnlogin, show;
    DatabaseReference reff;
    String ph, nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_data_layout);

        name=(TextView)findViewById(R.id.tvname);
        age=(TextView)findViewById(R.id.tvage);
        height=(TextView)findViewById(R.id.tvheight);
        phone=(TextView)findViewById(R.id.tvphone);
        etenterphone=(EditText)findViewById(R.id.etenterphone); //login
        etentername=(EditText)findViewById(R.id.etentername); //login
        show=(Button)findViewById(R.id.btnshow);
        btnlogin=(Button)findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ph=etenterphone.getText().toString();
                nm=etentername.getText().toString();

                reff= FirebaseDatabase.getInstance().getReference().child("Member").child(ph);
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String n=dataSnapshot.child("name").getValue().toString();

                        if (nm.equals(n))
                        {
                            Toast.makeText(ShowDataActivity.this, "successful",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(ShowDataActivity.this, "wrong",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reff= FirebaseDatabase.getInstance().getReference().child("Member").child("2");
                reff= FirebaseDatabase.getInstance().getReference().child("Member").child(ph);
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String n=dataSnapshot.child("name").getValue().toString();
                        String a=dataSnapshot.child("age").getValue().toString();
                        String h=dataSnapshot.child("height").getValue().toString();
                        String p=dataSnapshot.child("phone").getValue().toString();

                        name.setText(n);
                        age.setText(a);
                        height.setText(h);
                        phone.setText(p);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
