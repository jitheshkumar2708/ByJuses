package com.example.byjuses.UI;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.byjuses.Data.NewsClint;
import com.example.byjuses.Models.Root;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewsViewModel  extends ViewModel {

    private static final String TAG = "NewsViewModel";
    MutableLiveData<Root> liveData = new MutableLiveData<>();


    public void getNewsLiveData() {
        Observable observable = NewsClint.getINSTANCE().GetNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<Root> observer = new Observer<Root>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Root root) {
                liveData.setValue(root);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };


        observable.subscribe(observer);


    }
}
