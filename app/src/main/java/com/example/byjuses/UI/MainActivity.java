package com.example.byjuses.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.byjuses.Adapter.RecyclerAdapter;
import com.example.byjuses.Models.NewsModel;
import com.example.byjuses.MyViewModel;
import com.example.byjuses.R;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    //List<NewsModel> list = new ArrayList<>();
   Context context;
    MyViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textView= (TextView) findViewById(R.id.toolbar_title);

        Typeface roboto = Typeface.createFromAsset(this.getAssets(),
                "font/RobotoSlab-Bold.ttf");

        //use this.getAssets if you are calling from an Activity
        textView.setTypeface(roboto);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);



        mViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        mViewModel.getNewsLiveData();
        mViewModel.getAllNews().observe(this, new Observer<List<NewsModel>>() {
            @Override
            public void onChanged(List<NewsModel> newsModels) {
                if (!newsModels.isEmpty())
                    adapter.setList(newsModels, getApplicationContext());


                /*for (int i = 0; i < newsModels.size(); i++) {
                    NewsModel newsModel = new NewsModel(newsModels.get(i).getAuthor(),
                            newsModels.get(i).getTitle(),
                            newsModels.get(i).getDescription(),
                            newsModels.get(i).getUrl(),
                            newsModels.get(i).getUrlToImage(),
                            newsModels.get(i).getPublishedAt());
                    newsModel.setId(i);
                    mViewModel.insert(newsModel);
                }*/



            }
        });







        //adapter = new RecyclerAdapter(list, this);





        /*mViewModel.liveData.observe(this, new Observer<Root>() {
            @Override
            public void onChanged(Root root) {
                if (root != null) {
                    list = root.getArticles();
                    for (int i = 0; i < list.size(); i++) {
                        adapter.setList(list, getApplicationContext());
                        //adapter = new RecyclerAdapter(list, getApplicationContext());
                        recyclerView.setAdapter(adapter);
                        //adapter.notifyDataSetChanged();
                    }
                }
            }
        });*/


    }

    /*public void openNews(Context context, String posation) {
        Uri newsUri = Uri.parse(posation);
        //adapter.getItemId((int) posation);
        //Toast.makeText(context, "mainactivity" + posation, Toast.LENGTH_SHORT).show();
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
        startActivity(websiteIntent);
    }*/


}