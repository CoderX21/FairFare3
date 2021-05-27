package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TakeDistance extends AppCompatActivity {

    ImageButton i1,i2,i3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_distance);

        i1 = (ImageButton)findViewById(R.id.imageButton);
        i2 = (ImageButton)findViewById(R.id.imageButton2);
        i3 = (ImageButton)findViewById(R.id.imageButton3);
    }

    public void Selection(View view) {

        MainActivity.B1=1;
        Intent intent = new Intent(this, Taxi.class);
        startActivity(intent);
    }
    public void bus(View view) {
        MainActivity.B1=2;
        Intent intent = new Intent(this, Bus.class);
        startActivity(intent);
    }
    public void rickshaw(View view) {
        MainActivity.B1=3;
        Intent intent = new Intent(this, rickshaw.class);
        startActivity(intent);
    }

}