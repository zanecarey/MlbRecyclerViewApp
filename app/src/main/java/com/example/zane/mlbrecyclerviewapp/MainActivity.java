package com.example.zane.mlbrecyclerviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //TAG for debugging
    private static final String TAG = "MainActivity";

    //Number of columns in our staggered RecyclerView
    private static final int NUM_COLUMNS = 2;

    //Tags to go along with our images
    private ArrayList<String> names = new ArrayList<>();
    //The actual image urls we will be using
    private ArrayList<String> imageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        //Add our images to the arraylist, add names for each image
        imageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        names.add("Rocky Mountains");

        imageUrls.add("https://i.redd.it/0u1u2m73uoz11.jpg");
        names.add("Mt. Baker, WA");

        imageUrls.add("https://i.redd.it/xgd2lnk56mz11.jpg");
        names.add("Falls Creek Falls, TN");

        imageUrls.add("https://i.redd.it/o6jc7peiimz11.jpg");
        names.add("Skogafoss, Iceland");

        imageUrls.add("https://i.redd.it/zxd44dfbyiz11.jpg");
        names.add("Black Forest, Germany");

        imageUrls.add("https://www.mountainphotography.com/images/xl/20090803-Hermannsdalstinden-Sunset.jpg");
        names.add("Lofoten Islands, Norway");

        imageUrls.add("https://i.redd.it/6vdpsld78cz11.jpg");
        names.add("Isle of Skye");

        imageUrls.add("https://i.redd.it/i4xb66v5eyy11.jpg");
        names.add("Lago di Carezza, Italy");

        imageUrls.add("https://i.redd.it/ttl7f4pwhhy11.jpg");
        names.add("Arches National Park, UT");

        imageUrls.add("https://i.redd.it/mcsxhejtkqy11.jpg");
        names.add("Northern Lights");

        imageUrls.add("https://i.redd.it/0rhq46ve83z11.jpg");
        names.add("Swiss Alps");

        imageUrls.add("https://i.redd.it/0dfwwitwjez11.jpg");
        names.add("Hunan, China");

        //Initialize our recyclerView now that we have our images/names
        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerView");

        //Create our recyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //Create an adapter for our recyclerview
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(names, imageUrls, this);

        //Set the layout style to a staggered gridview
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);

        //set the layout mode to LinearLayout
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        //set adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }
}