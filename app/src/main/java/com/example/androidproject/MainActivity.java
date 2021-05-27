package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText E1;
    public static int B1;
    public static String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        E1=(EditText)findViewById(R.id.name);



    }


    public void secondPage(View view) {
        Name=E1.getText().toString();

        Toast.makeText(this,"Welcome "+Name,Toast.LENGTH_LONG).show();

        Intent intent=new Intent(this,TakeDistance.class);
        startActivity(intent);

    }
}