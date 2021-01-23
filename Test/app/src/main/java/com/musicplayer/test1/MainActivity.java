package com.musicplayer.test1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //
    TextView textView;
    Button dial, toast, show_location, open_webpage, viewIntent, letsGetPro;

    //Test


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //related to view

        //
        textView = (TextView)findViewById(R.id.textView1);

        dial = (Button)findViewById(R.id.dial);
        toast = (Button)findViewById(R.id.toast);
        show_location = (Button)findViewById(R.id.show_location);
        open_webpage = (Button)findViewById(R.id.open_webpage);
        viewIntent = (Button)findViewById(R.id.viewIntent);
        letsGetPro = (Button)findViewById(R.id.letsGetPro);

        dial.setOnClickListener(this);
        toast.setOnClickListener(this);
        show_location.setOnClickListener(this);
        open_webpage.setOnClickListener(this);
        viewIntent.setOnClickListener(this);
        letsGetPro.setOnClickListener(this);

        /*
        //Event Listener
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("tag","push");
                textView.setText("you have pushed");
            }
        });

        push2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("tag","push 2");
                textView.setText("you have pushed 2");
            }
        });
        */

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn1 :
                Log.d("tag","push");
                textView.setText("you have pushed");
                break;
            case R.id.btn2 :
                Log.d("tag","push 2");
                textView.setText("you have pushed 2");
                break;
        }
    }
    */

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.dial:
                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567890"));
                startActivity(intent2);
                break;
            case R.id.toast:
                Intent intent = new Intent(MainActivity.this,Activity2.class);
                startActivity(intent);
                break;
            case R.id.show_location:
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:22.6051723,88.4684893,17.42"));
                startActivity(intent3);
                break;
            case R.id.open_webpage:
                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(intent4);
                break;
            case R.id.viewIntent:
                //to show all the intent
                Intent intent5 = new Intent(Intent.ACTION_VIEW);
                startActivity(intent5);
                break;
            case R.id.letsGetPro:
                //getting close to component
                //Intent intent6 = new Intent("com.musicplayer.test1.Activity2");
                //startActivity(intent6);
                Intent intent7 = new Intent(Intent.ACTION_VIEW);
                intent7.putExtra("KEY","Value is my data...");
                startActivity(intent7);
                break;
        }
    }
}
