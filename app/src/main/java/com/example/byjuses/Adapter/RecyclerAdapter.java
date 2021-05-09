package com.example.byjuses.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.byjuses.Models.NewsModel;
import com.example.byjuses.R;
import com.example.byjuses.UI.DescriptionActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.View_Holder> {

    public List<NewsModel> list = new ArrayList<>();
    Context context;

    public class View_Holder extends RecyclerView.ViewHolder {

        public View view;
        public TextView newsDate,newsTitle,newsName;
        public ImageView newsImage;

        public View_Holder(@NonNull View itemView) {
            super(itemView);

            view = itemView;
            newsDate = itemView.findViewById(R.id.date);
            newsTitle = itemView.findViewById(R.id.title);
            newsImage = itemView.findViewById(R.id.image);
            newsName=  itemView.findViewById(R.id.titleHead);

        }
    }


    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new View_Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {

        String input = list.get(position).getPublishedAt();
        String output = input.substring(0, 10);
        holder.newsDate.setText(output);
        holder.newsTitle.setText(list.get(position).getTitle());
        holder.newsName.setText(list.get(position).getSource().getName());

        Typeface roboto = Typeface.createFromAsset(context.getAssets(),
                "font/RobotoSlab-Regular.ttf");

        holder.newsTitle.setTypeface(roboto);

        Typeface robo = Typeface.createFromAsset(context.getAssets(),
                "font/RobotoSlab-Bold.ttf");
        holder.newsName.setTypeface(robo);


        Picasso.get().load(list.get(position).getUrlToImage()).
                placeholder(R.drawable.byjus).
                into(holder.newsImage);


        ((View_Holder) holder).view.setOnClickListener(v -> {

            Intent intent = new Intent(context, DescriptionActivity.class);
            intent.putExtra("title",list.get(position).getTitle());
            intent.putExtra("ImageUri",list.get(position).getUrlToImage());
            intent.putExtra("description",list.get(position).getDescription());
            intent.putExtra("newsName",list.get(position).getSource().getName());
            intent.putExtra("date",output);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<NewsModel> getArrayList(){
        return list;
    }
    public void setList(List<NewsModel> list, Context context) {
        this.list = list;
        this.context = context;
        notifyDataSetChanged();
    }

}

