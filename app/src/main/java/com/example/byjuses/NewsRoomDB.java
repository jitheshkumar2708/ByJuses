package com.example.byjuses;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.byjuses.Models.NewsModel;
import com.example.byjuses.Models.SourceConverter;

@Database(entities = NewsModel.class, version = 2)
@TypeConverters(SourceConverter.class)
public abstract class NewsRoomDB extends RoomDatabase {

    private static NewsRoomDB instance;
    private static final String TAG = "NewsRoomDB";

    public abstract NewsDao newsDao();

    //Singlton
    public static synchronized NewsRoomDB getInstance(Context context) {

        if (instance == null) {
            Log.d(TAG, "mygetInstance: " + "null");
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NewsRoomDB.class,
                    "News_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        } else {
            Log.d(TAG, "mygetInstance: ");
        }
        return instance;
    }


    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulatDataAsyncTask(instance).execute();

        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }

    };


    private static class PopulatDataAsyncTask extends AsyncTask<Void, Void, Void> {

        private NewsDao mNewsDao;

        public PopulatDataAsyncTask(NewsRoomDB newsRoomDB) {
            mNewsDao = newsRoomDB.newsDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }

}
