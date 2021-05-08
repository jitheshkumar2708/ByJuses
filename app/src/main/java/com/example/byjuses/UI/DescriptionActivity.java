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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        newsImage = findViewById(R.id.flag);
        arrowBackImage = findViewById(R.id.flag1);
        newHeadline = findViewById(R.id.descriptionText);
        newsDescrption=findViewById(R.id.description_text);
        newsTitle=findViewById(R.id.titleName);
        newsDescriptionDate=findViewById(R.id.date_desc);

        String title = getIntent().getStringExtra("title");
        String image=getIntent().getStringExtra("ImageUri");
        String descriptionNews = getIntent().getStringExtra("description");
        String dateNews = getIntent().getStringExtra("date");
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
        newsDescrption.setText(descriptionNews);
        arrowBackImage.setClickable(true);
        arrowBackImage.setOnClickListener(v -> supportFinishAfterTransition());

    }
}
