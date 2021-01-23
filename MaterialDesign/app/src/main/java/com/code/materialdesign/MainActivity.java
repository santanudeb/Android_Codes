package com.code.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RelativeLayout CL1;
    private Button btn1;
    private MaterialCardView cd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab=(FloatingActionButton)findViewById(R.id.fab);
        CL1=(RelativeLayout)findViewById(R.id.CL1);
        btn1=(Button) findViewById(R.id.btnSnackbar);
        cd1=(MaterialCardView)findViewById(R.id.cv1);

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "CardView", Toast.LENGTH_LONG).show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_LONG).show();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackbar();
            }
        });
    }

    public void showSnackbar() {
        Snackbar.make(CL1, "This is a Snackbar", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this ,"Retry Clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(getColor(R.color.colorPrimary))  // Way 1 to show color dynamically
                .setTextColor(Color.RED)  // Way 2 to show color dynamically
                .show();
    }
}