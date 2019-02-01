package com.example.android.roomwithmoreentitiesapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.android.roomwithmoreentitiesapp.model.Google;

import java.util.List;

@Dao
public interface GoogleDao extends BaseDao<Google> {

    @Query("select * from google")
    LiveData<List<Google>> getAllGoogles();

    @Query("delete from google")
    void deleteAllGoogles();
}
