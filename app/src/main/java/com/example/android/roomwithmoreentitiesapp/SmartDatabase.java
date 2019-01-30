package com.example.android.roomwithmoreentitiesapp;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Google.class,Iphone.class},version = 1,exportSchema = false)
abstract class SmartDatabase extends RoomDatabase {

    private static SmartDatabase instance;

    abstract GoogleDao getGoogleDao();
    abstract IphoneDao getIphoneDao();

    static synchronized SmartDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    SmartDatabase.class,
                    "smartDatabase")
                    .addCallback(callback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };


    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{

        private GoogleDao googleDao;
        private IphoneDao iphoneDao;

        public PopulateDbAsyncTask(SmartDatabase database) {
            this.googleDao = database.getGoogleDao();
            this.iphoneDao = database.getIphoneDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            googleDao.insert(new Google("Pixel","Big One"));
            iphoneDao.insert(new Iphone("Xs","max"));
            return null;
        }
    }
}
