package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class rickshaw extends AppCompatActivity {

    EditText E1,E2;
    double result=0 ,Fresult=1;
    public static String strin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rickshaw);

        E1=(EditText)findViewById(R.id.distan);
        E2=(EditText)findViewById(R.id.seatas);
    }

    public void last(View view) {

        if (E2.getText().toString().equals("0")) {
            //Toast.makeText(this,"Minimum Seat Requirment is 1 !!")
            E2.setError("Minimum Seat Requirment is 1 !!");
        } else {
            result = Integer.parseInt((E1.getText().toString())) * 19.21;
            Fresult = Integer.parseInt((E2.getText().toString())) * result;

            strin = "Dear User. Thankyou for using our app Fare Fair.\n\n The Total amount you have to pay to Auto driver is " + Fresult + "\n One have to pay the amount of " + result +
                    " \n\n  We have calculated the average Auto price of India. The calculation has it's basis on following \n\n Current Petrol Price = 99.12 rs/litre \n Average Auto Price = 19.21 Rs\n Total No of Peoples = " + E2.getText().toString();

            Intent intent = new Intent(this, Result.class);
            startActivity(intent);
        }
    }
}