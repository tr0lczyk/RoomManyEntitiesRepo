package com.example.android.roomwithmoreentitiesapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.roomwithmoreentitiesapp.database.GoogleRepository;
import com.example.android.roomwithmoreentitiesapp.database.IphoneRepository;
import com.example.android.roomwithmoreentitiesapp.model.Google;
import com.example.android.roomwithmoreentitiesapp.model.Iphone;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Google> allGoogles;
    List<Iphone> allIphones;

    TextView textView;
    SmartViewModel smartViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        smartViewModel = ViewModelProviders.of(this).get(SmartViewModel.class);
        smartViewModel.getAllGoogles().observe(this, new Observer<List<Google>>() {
            @Override
            public void onChanged(@Nullable List<Google> googles) {
                allGoogles = googles;
            }
        });
        smartViewModel.getAllIphones().observe(this, new Observer<List<Iphone>>() {
            @Override
            public void onChanged(@Nullable List<Iphone> iphones) {
                allIphones = iphones;
                updateMainText();
            }
        });
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                googleRepository = new GoogleRepository(getApplication());
//                allGoogles = googleRepository.getAllGoogles();
//                updateMainText();
//            }
//        }).start();
    }

    public void updateMainText(){
        textView.setText("\n");
        textView.append(allIphones.get(0).getName() + "\n");
        textView.append(allGoogles.get(0).getName() + "\n");
    }
}
