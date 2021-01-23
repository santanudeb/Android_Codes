package com.musicplayer.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Toast.makeText(this, "opened other activity",Toast.LENGTH_SHORT).show();

        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("KEY");
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
