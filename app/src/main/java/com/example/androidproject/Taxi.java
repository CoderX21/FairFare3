package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Taxi extends AppCompatActivity {

    EditText E1,E2;
    double result=0,Fresult=1;
    public static String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi);

        E1=(EditText)findViewById(R.id.dist);
        E2=(EditText)findViewById(R.id.seat);


    }

    public void last(View view) {

        if (E2.getText().toString().equals("0"))
        {
            //Toast.makeText(this,"Minimum Seat Requirment is 1 !!")
            E2.setError("Minimum Seat Requirment is 1 !!");
        }

        else {
            result = Integer.parseInt((E1.getText().toString())) * 14.52;
            Fresult = Integer.parseInt((E2.getText().toString())) * result;

            Math.abs(result);
            Math.abs(Fresult);
            str = "Dear User. Thankyou for using our app Fare Fair.\n\n The Total amount you have to pay to taxi driver is " + Fresult +"\n One have to pay the amount of "+result+
                    " \n\n  We have calculated the average taxi price of India. The calculation has it's basis on following \n\n Current Petrol Price = 99.12 rs/litre \n Average Taxi Price = 14.53 Rs\n Total No of Peoples = " + E2.getText().toString();

            Intent intent = new Intent(this, Result.class);
            startActivity(intent);
        }
    }
}