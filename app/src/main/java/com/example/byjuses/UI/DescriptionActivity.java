package com.example.byjuses.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.byjuses.Adapter.RecyclerAdapter;
import com.example.byjuses.Models.NewsModel;
import com.example.byjuses.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

public class DescriptionActivity extends AppCompatActivity {

    RecyclerAdapter recyclerAdapter;
    ImageView imageView,drawerImage;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descriptionactivity);

        imageView = findViewById(R.id.flag);
        drawerImage = findViewById(R.id.flag1);
        textView = findViewById(R.id.descriptionText);
          String s = getIntent().getStringExtra("title");
          String d=getIntent().getStringExtra("ImageUri");


        Picasso.get().load(d).
                placeholder(R.drawable.ic_launcher_background).
                into(imageView);
                textView.setText(s);
       drawerImage.setClickable(true);
       drawerImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


           }
       });

    }
}
