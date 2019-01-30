package com.example.android.roomwithmoreentitiesapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface IphoneDao extends BaseDao<Iphone> {

    @Query("select * from iphone")
    List<Iphone> getAllIphones();

    @Query("delete from iphone")
    void deleteAllIphones();
}
