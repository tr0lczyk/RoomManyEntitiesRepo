package com.example.android.roomwithmoreentitiesapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.android.roomwithmoreentitiesapp.model.Iphone;

import java.util.List;

@Dao
public interface IphoneDao extends BaseDao<Iphone> {

    @Query("select * from iphone")
    LiveData<List<Iphone>> getAllIphones();

    @Query("delete from iphone")
    void deleteAllIphones();
}
