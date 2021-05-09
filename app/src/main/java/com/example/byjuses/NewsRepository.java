package com.example.byjuses;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.byjuses.Models.NewsModel;

import java.util.List;

public class NewsRepository {

    private NewsDao mNewsDao;

    private LiveData<List<NewsModel>> getAllNews;

    public NewsRepository(Application app) {
        NewsRoomDB db = NewsRoomDB.getInstance(app);
        mNewsDao = db.newsDao();
        getAllNews = mNewsDao.getAllNews();
    }

    public void insert(NewsModel newsModel) {
        new InsertAsyncTask(mNewsDao).execute(newsModel);
    }

    public void delete(NewsModel newsModel) {
        new DeleteAsyncTask(mNewsDao).execute(newsModel);
    }

    public void update(NewsModel newsModel) {
        new UpdateAsyncTask(mNewsDao).execute(newsModel);
    }

    public LiveData<List<NewsModel>> getAllNews() {
        return getAllNews;
    }

    public void deleteAllNews() {
        new DeleteAllNewsAsyncTask(mNewsDao).execute();
    }

    private static class InsertAsyncTask extends AsyncTask<NewsModel, Void, Void> {

        private NewsDao mNewsDao;

        public InsertAsyncTask(NewsDao mNewsDao) {
            this.mNewsDao = mNewsDao;
        }

        @Override
        protected Void doInBackground(NewsModel... newsModels) {

            mNewsDao.insert(newsModels[0]);
            return null;
        }
    }


    private static class DeleteAsyncTask extends AsyncTask<NewsModel, Void, Void> {

        private NewsDao mNewsDao;

        public DeleteAsyncTask(NewsDao mNewsDao) {
            this.mNewsDao = mNewsDao;
        }

        @Override
        protected Void doInBackground(NewsModel... newsModels) {

            mNewsDao.delete(newsModels[0]);
            return null;
        }
    }


    private static class UpdateAsyncTask extends AsyncTask<NewsModel, Void, Void> {

        private NewsDao mNewsDao;

        public UpdateAsyncTask(NewsDao mNewsDao) {
            this.mNewsDao = mNewsDao;
        }

        @Override
        protected Void doInBackground(NewsModel... newsModels) {

            mNewsDao.update(newsModels[0]);
            return null;
        }
    }

    private static class DeleteAllNewsAsyncTask extends AsyncTask<Void, Void, Void> {

        private NewsDao mNewsDao;

        public DeleteAllNewsAsyncTask(NewsDao mNewsDao) {
            this.mNewsDao = mNewsDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mNewsDao.deleteAll();
            return null;
        }
    }

}
