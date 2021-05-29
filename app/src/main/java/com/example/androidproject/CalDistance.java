package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CalDistance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_distance);
    }

    public void man(View view) {

        Intent intent = new Intent(this,TakeDistance.class);
        startActivity(intent);

    }

    public void auto(View view) {

        Intent intent = new Intent(this,AutoDistance.class);
        startActivity(intent);


    }
}