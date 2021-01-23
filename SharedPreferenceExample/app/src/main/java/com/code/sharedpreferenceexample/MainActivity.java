package com.code.sharedpreferenceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText textname, textage;
    SeekBar sb;
    Button b;
    private String prefName="mypreferences"; // name of the SharedPreference
    SharedPreferences pref; //pref is variable of SharedPreferences class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textname=(EditText)findViewById(R.id.editText1);
        textage=(EditText)findViewById(R.id.editText2);
        sb=(SeekBar)findViewById(R.id.seekBar1);
        b=(Button)findViewById(R.id.button1);

        pref=getSharedPreferences(prefName, MODE_PRIVATE); //for getting SharedPreferences if never used.

        String nm=pref.getString("username","[Enter Your Name]"); //(key,value) //getString is for getting value if it's not there
        textname.setText(nm);
        int age=pref.getInt("userage", 0); //(key,value)
        textage.setText(String.valueOf(age));
        float fsize=pref.getFloat("fontsize",12f); //(key,value)
        sb.setProgress((int)fsize);
        textname.setTextSize(fsize);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref=getSharedPreferences(prefName, MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit(); //SharedPreferences.Editor for editing existing values

                editor.putString("username", textname.getText().toString()); //(key,value) //putString is for editing value
                editor.putInt("userage", Integer.parseInt(textage.getText().toString())); //(key,value)
                editor.putFloat("fontsize", (float)sb.getProgress()); //(key,value)
                editor.commit(); //saving the change

                Toast.makeText(MainActivity.this,"Committed",Toast.LENGTH_LONG).show();
            }
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textname.setTextSize((float)sb.getProgress()); //size of the text in textname will be change if we make change in seekbar.
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

//SharedPreference notes
//Data of SharedPreference stored as XML
//light weight <key=a>abc</key> pair , abc is a value. (key,value)
//can be accessed from any activity
