package com.code.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView RvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RvContacts=(RecyclerView)findViewById(R.id.RvContacts);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Joaquin Phoenix", "JoaquinPhoenix@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/4/41/Joaquin_Phoenix_at_the_2018_Berlin_Film_Festival.jpg"));
        contacts.add(new Contact("Robert De Niro", "RobertDeNiro@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/1990_Venice_Film_Festival_Robert_De_Niro.jpg/1200px-1990_Venice_Film_Festival_Robert_De_Niro.jpg"));
        contacts.add(new Contact("Martin Scorsese", "MartinScorsese@gmail.com", "https://cdn.onebauer.media/one/media/5dc2/b22e/8e9e/584d/538d/1bff/martin-scorsese.jpg?quality=50&width=1800&ratio=16-9&resizeStyle=aspectfill&format=jpg"));
        contacts.add(new Contact("Steven Spielberg", "StevenSpielberg@gmail.com", "https://cdn.britannica.com/95/176995-050-609666E2/Steven-Spielberg-2013.jpg"));
        contacts.add(new Contact("Stanley Kubrick", "StanleyKubrick@gmail.com", "https://www.biography.com/.image/t_share/MTE1ODA0OTcxNjkyMTY0NjIx/stanley-kubrick-9369672-1-402.jpg"));
        contacts.add(new Contact("Christopher Nolan", "ChristopherNolan@gmail.com", "https://m.media-amazon.com/images/M/MV5BNjE3NDQyOTYyMV5BMl5BanBnXkFtZTcwODcyODU2Mw@@._V1_UY1200_CR118,0,630,1200_AL_.jpg"));

        ContactsRecyclerViewAdapter adapter = new ContactsRecyclerViewAdapter(this);
        adapter.setContacts(contacts);

        RvContacts.setAdapter(adapter);
        // RvContacts.setLayoutManager(new LinearLayoutManager(this));  // list view
        // RvContacts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)); // side view
        RvContacts.setLayoutManager(new GridLayoutManager(this, 2));  //  grid view
    }
}