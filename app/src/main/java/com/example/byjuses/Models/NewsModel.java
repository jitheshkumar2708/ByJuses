package com.example.byjuses.Models;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "newsTable")
public class NewsModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String  author;
    private String  title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String name;

    public NewsModel(String author, String title, String description, String url, String urlToImage, String publishedAt,String name) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.name=name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getName() {
        return name;
    }
}