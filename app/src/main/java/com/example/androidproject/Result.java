package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t=(TextView)findViewById(R.id.res);

        if (MainActivity.B1==1)
            t.setText(""+Taxi.str);

        if (MainActivity.B1==2)
            t.setText(""+Bus.stri);

        if (MainActivity.B1==3)
            t.setText(""+rickshaw.strin);
    }

    public void exit(View view) {

        Toast.makeText(this,"Thankyou" +MainActivity.Name +"Happy Journey !!",Toast.LENGTH_LONG).show();
       /* android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);*/
        this.finishAffinity();
    }

    public void menu(View view) {

        Intent intent=new Intent(this,TakeDistance.class);
        startActivity(intent);
    }
}