package com.example.byjuses.UI;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.byjuses.R;
import com.squareup.picasso.Picasso;

public class DescriptionActivity extends AppCompatActivity {

   
    ImageView newsImage,arrowBackImage;
    TextView newHeadline,newsDescrption,newsTitle,newsDescriptionDate;
    String title,image,descriptionNews,dateNews,newsName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        newsImage = findViewById(R.id.newsImage);
        arrowBackImage = findViewById(R.id.arrowImage);
        newHeadline = findViewById(R.id.newsHeadline);
        newsDescrption=findViewById(R.id.newsDescription);
        newsTitle=findViewById(R.id.newsName);
        newsDescriptionDate=findViewById(R.id.newsDate);

        title  = getIntent().getStringExtra("title");
        image  = getIntent().getStringExtra("ImageUri");
        descriptionNews = getIntent().getStringExtra("description");
        dateNews = getIntent().getStringExtra("date");
        newsName= getIntent().getStringExtra("newsName");
        Typeface roboto = Typeface.createFromAsset(this.getAssets(),
                "font/RobotoSlab-Bold.ttf");
        
        newHeadline.setTypeface(roboto);

        Typeface robo = Typeface.createFromAsset(this.getAssets(),
                "font/RobotoSlab-Regular.ttf");
        
        newsDescrption.setTypeface(robo);
        newsDescriptionDate.setTypeface(robo);



        Picasso.get().load(image).
                placeholder(R.drawable.byjus).
                into(newsImage);
        newHeadline.setText(title);
        newsDescriptionDate.setText(dateNews);
        newsTitle.setText(newsName);
        newsTitle.setTypeface(roboto);
        newsDescrption.setText(descriptionNews);
        arrowBackImage.setClickable(true);
        arrowBackImage.setOnClickListener(v -> supportFinishAfterTransition());

    }
}
