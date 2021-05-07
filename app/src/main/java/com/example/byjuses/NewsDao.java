package com.example.byjuses;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.byjuses.Models.NewsModel;

import java.util.List;

public interface NewsDao {

    @Insert
    void insert(NewsModel newsModel);

    @Update
    void update(NewsModel newsModel);

    @Delete
    void delete(NewsModel newsModel);

    @Query("DELETE From newsTable")
    void deleteAll();


    @Query("SELECT * From newsTable")
    LiveData<List<NewsModel>> getAllNews();
}
