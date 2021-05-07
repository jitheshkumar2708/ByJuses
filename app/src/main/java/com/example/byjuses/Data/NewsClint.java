package com.example.byjuses.Data;

import com.example.byjuses.Models.Root;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsClint {

    private static final String BASE_URL = "https://newsapi.org/";
    private NewsInterface newsInterface;
    private static NewsClint INSTANCE;


    public NewsClint() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        newsInterface =  retrofit.create(NewsInterface.class);

    }

    public static NewsClint getINSTANCE() {

        if (null == INSTANCE)
            INSTANCE = new NewsClint();

        return INSTANCE;
    }


    public Observable<Root> GetNews (){
        return newsInterface.getNews();
    }


}
