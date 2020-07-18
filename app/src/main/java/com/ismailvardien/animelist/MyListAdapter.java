package com.ismailvardien.animelist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class MyListAdapter extends ArrayAdapter<Manga> {


    //the list values in the List of type hero
    List<Manga> mangaList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public MyListAdapter(Context context, int resource, List<Manga> mangaList) {
        super(context, resource, mangaList);
        this.context = context;
        this.resource = resource;
        this.mangaList = mangaList;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        ImageView imageView = view.findViewById(R.id.imageView);
        final TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewTeam = view.findViewById(R.id.textViewTeam);
        Button buttonDelete = view.findViewById(R.id.buttonDelete);


        //getting the hero of the specified position
        final Manga manga = mangaList.get(position);

        //adding values to the list item
        imageView.setImageDrawable(context.getResources().getDrawable(manga.getImage()));
        textViewName.setText(manga.getName());
        textViewTeam.setText(manga.getTeam());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(position == 0) {
                    //code specific to first list item
                    Toast.makeText(context.getApplicationContext(),"You Selected: Bleach 24 - Immanent Blues God",Toast.LENGTH_SHORT).show();
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(context.getApplicationContext(),"You Selected: Bleach 65 - Marching Out The Zombies",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {
                    Toast.makeText(context.getApplicationContext(),"You Selected: Bleach 49 - The Lost Agent",Toast.LENGTH_SHORT).show();

                }
                else if(position == 3) {

                    Toast.makeText(context.getApplicationContext(),"You Selected: Bleach 74 - The Death And The Strawberry",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {

                    Toast.makeText(context.getApplicationContext(),"You Selected: Bleach 30 - There Is No Heart Without You",Toast.LENGTH_SHORT).show();
                }
                else if(position == 5) {

                    Toast.makeText(context.getApplicationContext(),"You Selected: Bleach 32 - Howling",Toast.LENGTH_SHORT).show();
                }
                else if(position == 6) {

                    Toast.makeText(context.getApplicationContext(),"You Selected: Bleach 48 - God Is Dead",Toast.LENGTH_SHORT).show();
                }
                else if(position == 7) {

                    Toast.makeText(context.getApplicationContext(),"You Selected: Bleach 26 - The Mascaron Drive",Toast.LENGTH_SHORT).show();
                }
                else if(position == 8) {

                    Toast.makeText(context.getApplicationContext(),"You Selected: Bleach 40 - The Lust",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //adding a click listener to the button to remove item from the list
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //we will call this method to remove the selected value from the list
                //we are passing the position which is to be removed in the method
                removeHero(position);
            }
        });



        //finally returning the view
        return view;
    }

    //this method will remove the item from the list
    private void removeHero(final int position) {
        //Creating an alert dialog to confirm the deletion
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete?");

        //if the response is positive in the alert
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //removing the item
                mangaList.remove(position);

                //reloading the list
                notifyDataSetChanged();
            }
        });

        //if response is negative nothing is being done
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //creating and displaying the alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}