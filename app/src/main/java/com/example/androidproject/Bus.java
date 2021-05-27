package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Bus extends AppCompatActivity {

    EditText E1,E2;
    double result=0;
    public static String stri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        E1=(EditText)findViewById(R.id.dista);
        E2=(EditText)findViewById(R.id.seata);
    }

    public void last(View view) {

        result = Double.parseDouble ((E1.getText().toString()))*2.8;
        stri = "Dear User. Thankyou for using our app Fare Fair.\n\n\n\n The Total amount you have to pay to Bus Conductor is "+result+
                "\n\n\n We have calculated the average Bus(Non-AC) price of India. The calculation has it's basis on following \n\n Current Petrol Price = 99.12 rs/litre \n Average Bus Price = 2.8 Rs";

        Intent intent = new Intent(this,Result.class);
        startActivity(intent);
    }
}