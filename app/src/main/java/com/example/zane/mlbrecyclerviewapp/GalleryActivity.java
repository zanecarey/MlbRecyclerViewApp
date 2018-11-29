package com.example.zane.mlbrecyclerviewapp;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        //Check if the intent data exists before attempting to retrieve it
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra("description_value")){

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            int index = getIntent().getIntExtra("description_value", 0);
            setImage(imageUrl, imageName, index);
        }
    }

    private void setImage(String imageUrl, String imageName, int index){

        TextView name = findViewById(R.id.imageDescription);
        TextView info = findViewById(R.id.imageInfo);
        //get index of info array
        SpannableString content = new SpannableString(imageName);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        name.setText(content);
        info.setText(LocationInfo.DESCRIPTIONS[index]);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}
