package com.example.android.roomwithmoreentitiesapp;

import android.app.Application;

abstract class BaseRepository<T> {

    public SmartDatabase database;

    public BaseRepository(Application application){
        database = SmartDatabase.getInstance(application);
    }

    abstract void insert(T object);

    abstract void update(T object);

    abstract void delete(T object);

    abstract void deleteAllObjects();
}
