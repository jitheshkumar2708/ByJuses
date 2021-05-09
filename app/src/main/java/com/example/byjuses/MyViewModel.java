package com.example.byjuses;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.byjuses.Data.NewsClint;
import com.example.byjuses.Models.NewsModel;
import com.example.byjuses.Models.Root;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MyViewModel extends AndroidViewModel {

    private static final String TAG = "MyViewModel";
    private NewsRepository mRepository;

    private LiveData<List<NewsModel>> mAllNews;


    public MyViewModel(@NonNull Application application) {
        super(application);

        mRepository = new NewsRepository(application);
        mAllNews = mRepository.getAllNews();
    }


    public void insert(NewsModel newsModel) {
        mRepository.insert(newsModel);
    }

    public void delete(NewsModel newsModel) {
        mRepository.delete(newsModel);
    }

    public void update(NewsModel newsModel) {
        mRepository.update(newsModel);
    }

    public void deleteAllNews() {
        mRepository.deleteAllNews();
    }

    public LiveData<List<NewsModel>> getAllNews() {
        return mAllNews;
    }


    MutableLiveData<Root> liveData = new MutableLiveData<>();


    public void getNewsLiveData() {
        Observable observable = NewsClint.getINSTANCE().GetNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<Root> observer = new Observer<Root>() {
            @Override
            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

            }

            @Override
            public void onNext(@io.reactivex.rxjava3.annotations.NonNull Root root) {
                deleteAllNews();
                for (int i = 0; i < root.getArticles().size(); i++) {
                    NewsModel newsModel = new NewsModel(root.getArticles().get(i).getSource(), root.getArticles().get(i).getAuthor(),
                            root.getArticles().get(i).getTitle(),
                            root.getArticles().get(i).getDescription(),
                            root.getArticles().get(i).getUrl(),
                            root.getArticles().get(i).getUrlToImage(),
                            root.getArticles().get(i).getPublishedAt());


                    insert(newsModel);


                }

                liveData.setValue(root);
            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }


            @Override
            public void onComplete() {

            }
        };


        observable.subscribe(observer);


    }
}


