package com.ismailvardien.animelist;


import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //a List of type hero for holding list items
    List<Manga> mangalist;

    //the listview
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing objects
        mangalist = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);

        //adding some values to our list
        mangalist.add(new Manga(R.drawable.bleach_1, "Bleach 24", "Immanent God Blues"));
        mangalist.add(new Manga(R.drawable.bleach_2, "Bleach 65", "Marching The Zombies Out"));
        mangalist.add(new Manga(R.drawable.bleach_3, "Bleach 49", "The Lost Agent"));
        mangalist.add(new Manga(R.drawable.bleach_4, "Bleach 74", "The Death Of The Strawberry"));
        mangalist.add(new Manga(R.drawable.bleach_5, "Bleach 30", "There Is No Heart Without You"));
        mangalist.add(new Manga(R.drawable.bleach_6, "Bleach 32", "Howling"));
        mangalist.add(new Manga(R.drawable.bleach_7, "Bleach 48", "God Is Dead"));
        mangalist.add(new Manga(R.drawable.bleach_8, "Bleach 26", "The Mascaron Drive"));
        mangalist.add(new Manga(R.drawable.bleach_9, "Bleach 40", "The Lust"));

        //creating the adapter
        MyListAdapter adapter = new MyListAdapter(this, R.layout.mylist, mangalist);

        //attaching adapter to the listview
        listView.setAdapter(adapter);
    }
}