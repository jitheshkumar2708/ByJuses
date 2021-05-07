package com.example.byjuses.UI;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.byjuses.Adapter.RecyclerAdapter;
import com.example.byjuses.Models.NewsModel;
import com.example.byjuses.R;

import java.util.List;

public class DescriptionActivity extends AppCompatActivity {

    RecyclerAdapter recyclerAdapter;
    ImageView imageView,drawerImage;
    TextView textView;
    List<NewsModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descriptionactivity);

        imageView=findViewById(R.id.flag);
        drawerImage=findViewById(R.id.flag1);
        textView=findViewById(R.id.descriptionText);
        //Bundle bundle = getIntent().getExtras();
        //  list = Objects.requireNonNull(bundle).getParcelable("data");



     /* for(int i = 0; i< Objects.requireNonNull(list).size(); i++)
      {
          textView.setText(list.get(i).getTitle());

      }
*/
    }

}
