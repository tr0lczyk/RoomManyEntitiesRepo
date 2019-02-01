package com.example.android.roomwithmoreentitiesapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

@Dao
public interface BaseDao<T> {

    @Insert
    void insert(T object);

    @Update
    void update(T object);

    @Delete
    void delete(T object);
}
