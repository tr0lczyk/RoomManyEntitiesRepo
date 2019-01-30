package com.example.android.roomwithmoreentitiesapp;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

public class IphoneRepository extends BaseRepository<Iphone> {

    private IphoneDao iphoneDao;
    private List<Iphone> iphones;

    public IphoneRepository(Application application) {
        super(application);
        iphoneDao = database.getIphoneDao();
        iphones = iphoneDao.getAllIphones();
    }

    @Override
    void insert(Iphone object) {
        new InsertAsyncTask(iphoneDao).execute(object);
    }

    @Override
    void update(Iphone object) {
        new UpdateAsyncTask(iphoneDao).execute(object);
    }

    @Override
    void delete(Iphone object) {
        new DeleteAsyncTask(iphoneDao).execute(object);
    }

    @Override
    void deleteAllObjects() {
        new DeleteAllAsyncTask(iphoneDao).execute();
    }

    List<Iphone> getAllIphones(){
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
