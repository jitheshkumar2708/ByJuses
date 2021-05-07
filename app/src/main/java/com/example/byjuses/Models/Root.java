package com.example.byjuses.Models;

import java.util.List;

public class Root {

    private List<NewsModel> articles;

    public Root(List<NewsModel> articles) {
        this.articles = articles;
    }

    public List<NewsModel> getArticles() {
        return articles;
    }
}
