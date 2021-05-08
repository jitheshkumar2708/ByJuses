package com.example.byjuses.UI;

import android.content.Intent;
import android.graphics.Typeface;
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
    TextView textView,descrption,titleName,date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descriptionactivity);

        imageView = findViewById(R.id.flag);
        drawerImage = findViewById(R.id.flag1);
        textView = findViewById(R.id.descriptionText);
        descrption=findViewById(R.id.description_text);
        titleName=findViewById(R.id.titleName);
        date=findViewById(R.id.date_desc);

          String title = getIntent().getStringExtra("title");
          String image=getIntent().getStringExtra("ImageUri");
        String descriptionNews = getIntent().getStringExtra("description");
        String dateNews = getIntent().getStringExtra("date");
        Typeface roboto = Typeface.createFromAsset(this.getAssets(),
                "font/RobotoSlab-Bold.ttf");

        //use this.getAssets if you are calling from an Activity
        textView.setTypeface(roboto);

        Typeface robo = Typeface.createFromAsset(this.getAssets(),
                "font/RobotoSlab-Regular.ttf");

        //use this.getAssets if you are calling from an Activity
        descrption.setTypeface(robo);
        date.setTypeface(robo);



        Picasso.get().load(image).
                placeholder(R.drawable.ic_launcher_background).
                into(imageView);
                textView.setText(title);
                date.setText(dateNews);
                descrption.setText(descriptionNews);
       drawerImage.setClickable(true);
       drawerImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             supportFinishAfterTransition();
           }
       });

    }
}
