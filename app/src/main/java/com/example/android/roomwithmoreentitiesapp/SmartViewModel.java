package com.example.android.roomwithmoreentitiesapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.android.roomwithmoreentitiesapp.database.GoogleRepository;
import com.example.android.roomwithmoreentitiesapp.database.IphoneRepository;
import com.example.android.roomwithmoreentitiesapp.model.Google;
import com.example.android.roomwithmoreentitiesapp.model.Iphone;

import java.util.List;

public class SmartViewModel extends AndroidViewModel {

    private GoogleRepository googleRepository;
    private IphoneRepository iphoneRepository;
    private LiveData<List<Google>> allGoogles;
    private LiveData<List<Iphone>> allIphones;

    public SmartViewModel(@NonNull Application application) {
        super(application);
        googleRepository = new GoogleRepository(application);
        iphoneRepository = new IphoneRepository(application);
        allGoogles = googleRepository.getAllGoogles();
        allIphones = iphoneRepository.getAllIphones();
    }

    public LiveData<List<Google>> getAllGoogles(){
        return allGoogles;
    }

    public LiveData<List<Iphone>> getAllIphones(){
        return allIphones;
    }
}
