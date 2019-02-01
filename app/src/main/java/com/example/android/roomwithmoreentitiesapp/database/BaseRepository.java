package com.example.android.roomwithmoreentitiesapp.database;

import android.app.Application;

abstract class BaseRepository<T> {

    public SmartDatabase database;

    public BaseRepository(Application application){
        database = SmartDatabase.getInstance(application);
    }

    public abstract void insert(T object);

    public abstract void update(T object);

    public abstract void delete(T object);

    public abstract void deleteAllObjects();
}
