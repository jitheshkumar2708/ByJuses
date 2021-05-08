package com.example.byjuses.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.byjuses.Models.NewsModel;
import com.example.byjuses.R;
import com.example.byjuses.UI.DescriptionActivity;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.View_Holder> {

    public List<NewsModel> list = new ArrayList<>();
    Context context;


    public interface RecyclerCallBack{
        void onItemClicked(List<NewsModel> list);
    }
    RecyclerCallBack callback;

    public class View_Holder extends RecyclerView.ViewHolder {

        public View view;
        public TextView date, time, title,name;
        public ImageView image;

        public View_Holder(@NonNull View itemView) {
            super(itemView);

            view = itemView;

            date = itemView.findViewById(R.id.date);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
            name=  itemView.findViewById(R.id.titleHead);


        }


    }


    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new View_Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.newslist, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {

        /*NewsModel currentNews = list.get(position);
        holder.date.setText(currentNews.getPublishedAt());*/

        holder.date.setText(list.get(position).getPublishedAt());
        // holder.time.setText(list.get(position).getPublishedAt());
        holder.title.setText(list.get(position).getTitle());
        holder.name.setText(list.get(position).getName());

        Typeface roboto = Typeface.createFromAsset(context.getAssets(),
                "font/RobotoSlab-Regular.ttf");
        //use this.getAssets if you are calling from an Activity
        holder.name.setTypeface(roboto);




        Picasso.get().load(list.get(position).getUrlToImage()).
                placeholder(R.drawable.ic_launcher_background).
                into(holder.image);


        final int index = holder.getAdapterPosition();
        ((View_Holder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DescriptionActivity.class);
                intent.putExtra("title",list.get(position).getTitle());
                intent.putExtra("ImageUri",list.get(position).getUrlToImage());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


        String dateObject = new String(list.get(position).getPublishedAt());


        //TextView dataView = (TextView) view.findViewById(R.id.date_view);
        String formattedDate = formatDate(dateObject);
        //  holder.date.setText(formattedDate);

        //da.setText(formattedDate);

        //TextView timeView = (TextView) view.findViewById(R.id.time_view);
        String formatteTime = formatTime(dateObject);
        //   holder.time.setText(formatteTime);
        //timeView.setText(formatteTime);


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

    private String formatDate(String dateObject) {
        String DATE_FORMAT_I = "yyyy-MM-dd";
        String DATE_FORMAT_O = "yyyy LLL dd";
/*
        formatOutput.setTimeZone(TimeZone.getTimeZone("Asia/Dubai"));
        //formatOutput.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
*/

        SimpleDateFormat sourceFormat = new SimpleDateFormat(DATE_FORMAT_I);
        sourceFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parsed = null; // => Date is in UTC now
        try {
            parsed = sourceFormat.parse(dateObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        TimeZone tz = TimeZone.getTimeZone("Africa/Cairo");
        SimpleDateFormat destFormat = new SimpleDateFormat(DATE_FORMAT_O);
        destFormat.setTimeZone(tz);

        String dateString = destFormat.format(parsed);

        return dateString;
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(String dateObject) {

        String DATE_FORMAT_I = "yyyy-MM-dd";
        String DATE_FORMAT_O = "h:mm a";
/*
        formatOutput.setTimeZone(TimeZone.getTimeZone("Asia/Dubai"));
        //formatOutput.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
*/

        SimpleDateFormat sourceFormat = new SimpleDateFormat(DATE_FORMAT_I);
        sourceFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parsed = null; // => Date is in UTC now
        try {
            parsed = sourceFormat.parse(dateObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        TimeZone tz = TimeZone.getTimeZone("Africa/Cairo");
        SimpleDateFormat destFormat = new SimpleDateFormat(DATE_FORMAT_O);
        destFormat.setTimeZone(tz);

        String dateString = destFormat.format(parsed);

        return dateString;
    }
}

