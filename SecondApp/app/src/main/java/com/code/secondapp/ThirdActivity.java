package com.code.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    Intent k;
    Bundle br;
    String nm,g,ct;
    TextView tv,city;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        k=this.getIntent(); //retrieve the intent and storing it in variable
        br=k.getExtras(); //retrieve the bundle from intent and storing it in variable
        nm=br.getString("n1"); ////retrieve the value from bundle and storing it in variable
        g=br.getString("n2");
        ct=br.getString("n3");
        tv=(TextView)findViewById(R.id.tv_welcome);
        btn_back=(Button)findViewById(R.id.btn_back_home);
        city=(TextView)findViewById(R.id.tv_city);

        //
        if (g.equals("Male"))
        {
            tv.setText("Welcome Mr. "+nm);
        }
        else if (g.equals("Female"))
        {
            tv.setText("Welcome Mrs. "+nm);
        }

        //
        if (ct.equals("kolkata"))
        {
            city.setText("From "+ct);
        }
        if (ct.equals("mumbai"))
        {
            city.setText("From "+ct);
        }
        if (ct.equals("bangalore"))
        {
            city.setText("From "+ct);
        }
        if (ct.equals("pune"))
        {
            city.setText("From "+ct);
        }

        //
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(j);
            }
        });
    }
}
