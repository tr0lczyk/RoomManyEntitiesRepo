package com.example.android.roomwithmoreentitiesapp.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.android.roomwithmoreentitiesapp.model.Iphone;

import java.util.List;

public class IphoneRepository extends BaseRepository<Iphone> {

    private IphoneDao iphoneDao;
    private LiveData<List<Iphone>> iphones;

    public IphoneRepository(Application application) {
        super(application);
        iphoneDao = database.getIphoneDao();
        iphones = iphoneDao.getAllIphones();
    }

    @Override
    public void insert(Iphone object) {
        new InsertAsyncTask(iphoneDao).execute(object);
    }

    @Override
    public void update(Iphone object) {
        new UpdateAsyncTask(iphoneDao).execute(object);
    }

    @Override
    public void delete(Iphone object) {
        new DeleteAsyncTask(iphoneDao).execute(object);
    }

    @Override
    public void deleteAllObjects() {
        new DeleteAllAsyncTask(iphoneDao).execute();
    }

    public LiveData<List<Iphone>> getAllIphones(){
        return iphones;
    }

    private class InsertAsyncTask extends AsyncTask<Iphone,Void,Void>{

        private IphoneDao iphoneDao;

        public InsertAsyncTask(IphoneDao iphoneDao) {
            this.iphoneDao = iphoneDao;
        }

        @Override
        protected Void doInBackground(Iphone... iphones) {
            iphoneDao.insert(iphones[0]);
            return null;
        }
    }

    private class UpdateAsyncTask extends AsyncTask<Iphone,Void,Void>{

        private IphoneDao iphoneDao;

        public UpdateAsyncTask(IphoneDao iphoneDao) {
            this.iphoneDao = iphoneDao;
        }

        @Override
        protected Void doInBackground(Iphone... iphones) {
            iphoneDao.update(iphones[0]);
            return null;
        }
    }

    private class DeleteAsyncTask extends AsyncTask<Iphone,Void,Void>{

        private IphoneDao iphoneDao;

        public DeleteAsyncTask(IphoneDao iphoneDao) {
            this.iphoneDao = iphoneDao;
        }

        @Override
        protected Void doInBackground(Iphone... iphones) {
            iphoneDao.delete(iphones[0]);
            return null;
        }
    }

    private class DeleteAllAsyncTask extends AsyncTask<Iphone,Void,Void>{

        private IphoneDao iphoneDao;

        public DeleteAllAsyncTask(IphoneDao iphoneDao) {
            this.iphoneDao = iphoneDao;
        }

        @Override
        protected Void doInBackground(Iphone... iphones) {
            iphoneDao.deleteAllIphones();
            return null;
        }
    }


}
