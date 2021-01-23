package com.code.implicitintentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b_browse,b_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        b_browse=(Button)findViewById(R.id.btn_openbrowse);
        b_map=(Button)findViewById(R.id.btn_mapdisplay);

        b_browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ACTION_VIEW for viewing, it will open the url in browser. Uri class is for url to communicate
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(i);
            }
        });

        b_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //latitude longitude value, this is for fixed location
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.827500,-122.481670"));
                startActivity(i);
            }
        });
    }

    //calling from layout.xml
    public void callCustomer(View v) {
        //Address of telephon,"tel:" to make app understand it's phone number.
        Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:+065114161"));
        startActivity(i);
    }

    //https://www.androidauthority.com/how-to-create-android-notifications-707254//
    public void sendNotification(View v){
        //with NotificationCompat we can build notification, .Builder is a bulding class
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.icon)
                .setContentTitle("My Notification").setContentText("Hello");

        //to broadcast notification
        //getSystemService helps to receive the notification
        NotificationManager mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(001,mBuilder.build()); //notification id, .build() sending notification
    }

    //Email
    public void sendEmail(View v){
        Intent i = new Intent(MainActivity.this,EmailActivity.class);
        startActivity(i);
    }
}


//LocationManager for finding location using gps
//With ImplicitIntent we can communicate with other apps