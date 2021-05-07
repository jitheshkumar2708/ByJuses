package com.example.byjuses.Data;

import com.example.byjuses.Models.Root;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface NewsInterface {
    @GET("v2/everything?q=tesla&sortBy=publishedAt&apiKey=1f5044f7172045259c5da532fe86b512")
    Observable<Root> getNews();
}
