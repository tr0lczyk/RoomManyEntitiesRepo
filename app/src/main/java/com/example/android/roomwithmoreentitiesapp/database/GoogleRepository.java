package com.example.android.roomwithmoreentitiesapp.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.android.roomwithmoreentitiesapp.model.Google;

import java.util.List;

public class GoogleRepository extends BaseRepository<Google> {

    private GoogleDao googleDao;
    private LiveData<List<Google>> googles;

    public GoogleRepository(Application application) {
        super(application);
        googleDao = database.getGoogleDao();
        googles = googleDao.getAllGoogles();
    }

    @Override
    public void insert(Google object) {
        new InsertAsyncTask(googleDao).execute(object);
    }

    @Override
    public void update(Google object) {
        new UpdateAsyncTask(googleDao).execute(object);
    }

    @Override
    public void delete(Google object) {
        new DeleteAsyncTask(googleDao).execute(object);
    }

    @Override
    public void deleteAllObjects() {
        new DeleteAllAsyncTask(googleDao).execute();
    }

    public LiveData<List<Google>> getAllGoogles(){
        return googles;
    }

    private class InsertAsyncTask extends AsyncTask<Google,Void,Void>{

        private GoogleDao googleDao;

        public InsertAsyncTask(GoogleDao googleDao) {
            this.googleDao = googleDao;
        }

        @Override
        protected Void doInBackground(Google... googles) {
            googleDao.insert(googles[0]);
            return null;
        }
    }

    private class UpdateAsyncTask extends AsyncTask<Google,Void,Void>{

        private GoogleDao googleDao;

        public UpdateAsyncTask(GoogleDao googleDao) {
            this.googleDao = googleDao;
        }

        @Override
        protected Void doInBackground(Google... googles) {
            googleDao.update(googles[0]);
            return null;
        }
    }

    private class DeleteAsyncTask extends AsyncTask<Google,Void,Void>{

        private GoogleDao googleDao;

        public DeleteAsyncTask(GoogleDao googleDao) {
            this.googleDao = googleDao;
        }

        @Override
        protected Void doInBackground(Google... googles) {
            googleDao.delete(googles[0]);
            return null;
        }
    }

    private class DeleteAllAsyncTask extends AsyncTask<Google,Void,Void>{

        private GoogleDao googleDao;

        public DeleteAllAsyncTask(GoogleDao googleDao) {
            this.googleDao = googleDao;
        }

        @Override
        protected Void doInBackground(Google... googles) {
            googleDao.deleteAllGoogles();
            return null;
        }
    }
}
