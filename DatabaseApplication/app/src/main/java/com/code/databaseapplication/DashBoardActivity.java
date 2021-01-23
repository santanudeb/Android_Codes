package com.code.databaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class DashBoardActivity extends AppCompatActivity {

    Spinner s;
    String sp_items[]={"Select any","Display All","Update Menu","Delete Menu"}; //String array[] to show the values
    ArrayAdapter<String> aa; //ArrayAdapter to only link with String type, Strongly data types because we dont' need to do type convert

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dash_board_layout);

        s=(Spinner)findViewById(R.id.sp_dmenu);
        aa=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sp_items); //(this,style,object)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_item); //adding ArrayAdapter with Resource (Style) //initial
        s.setAdapter(aa); //setting spinner with adapter
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //i=index l=memory. values can be retrieve from view, index, memory any of these
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item=adapterView.getSelectedItem().toString(); //with adapterView
                if(item.equals("Display All"))
                {
                    Intent k=new Intent(DashBoardActivity.this,DisplayActivity.class);
                    startActivity(k);
                }
                if(item.equals("Update Menu"))
                {
                    Intent k=new Intent(DashBoardActivity.this,UpdateActivity.class);
                    startActivity(k);
                }
                if(item.equals(("Delete Menu")))
                {
                    Intent k=new Intent(DashBoardActivity.this,DeleteActivity.class);
                    startActivity(k);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu); //inflate the menu on ui (res location, Menu Object)
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {  //@NonNull
        switch (item.getItemId()) //id from menu.xml
        {
            case R.id.display_menu:
                Toast.makeText(DashBoardActivity.this,"Display All",Toast.LENGTH_LONG).show();
                Intent i=new Intent(DashBoardActivity.this,DisplayActivity.class);
                startActivity(i);
                return true;
            case R.id.update_menu:
                Toast.makeText(DashBoardActivity.this,"Update Menu",Toast.LENGTH_LONG).show();
                Intent j=new Intent(DashBoardActivity.this,UpdateActivity.class);
                startActivity(j);
                return true;
            case  R.id.delete_menu:
                Toast.makeText(DashBoardActivity.this,"Delete Menu",Toast.LENGTH_LONG).show();
                Intent k=new Intent(DashBoardActivity.this,DeleteActivity.class);
                startActivity(k);
        }
        return super.onOptionsItemSelected(item);
    }
}
