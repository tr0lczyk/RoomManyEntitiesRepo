package com.example.android.roomwithmoreentitiesapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface GoogleDao extends BaseDao<Google> {

    @Query("select * from google")
    List<Google> getAllGoogles();

    @Query("delete from google")
    void deleteAllGoogles();
}
