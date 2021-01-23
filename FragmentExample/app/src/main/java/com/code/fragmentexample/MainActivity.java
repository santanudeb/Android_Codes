package com.code.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bfirst,bsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bfirst=(Button)findViewById(R.id.b1);
        bsecond=(Button)findViewById(R.id.b2);

        bfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creating fragment
                FragmentManager fm = getFragmentManager(); //FragmentManager handles or manipulate frangments

                // create a FragmentTransaction to begin the transaction and replace the Fragment
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction(); //starting the fragment

                // replace the FrameLayout with new Fragment
                fragmentTransaction.replace(R.id.frame1, new FirstFragment());
                fragmentTransaction.commit(); //save changes
            }
        });

        bsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame1, new SecondFragment());
                fragmentTransaction.commit();
            }
        });
    }
}
