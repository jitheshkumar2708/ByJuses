package com.example.byjuses.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import com.example.byjuses.Adapter.RecyclerAdapter;
import com.example.byjuses.MyViewModel;
import com.example.byjuses.R;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    MyViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView textView = findViewById(R.id.toolbar_title);
        //To make Text Type as RobotoSlab-Bold
        Typeface roboto = Typeface.createFromAsset(this.getAssets(),
                "font/RobotoSlab-Bold.ttf");

        textView.setTypeface(roboto);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        mViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        mViewModel.getNewsLiveData();
        mViewModel.getAllNews().observe(this, newsModels -> {
            if (!newsModels.isEmpty())
                adapter.setList(newsModels, getApplicationContext());
        });

    }

}