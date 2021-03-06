package com.example.androidproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class AutoDistance extends AppCompatActivity {
    //Initialize
    EditText etSource,etDestination;
    TextView textView;
    String sType ;
    double lat1 =0, long1 =0, lat2 =0, long2 =0;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_distance);

        Toast.makeText(this,"This Feature is Under Construction",Toast.LENGTH_LONG).show();
        //Assign
        etSource = findViewById(R.id.et_source);
        etDestination = findViewById(R.id.et_destination);
        textView = findViewById(R.id.text_view);

        //Initialize Places
        Places.initialize(getApplicationContext(),"AIzaSyCc14fNdjS4HjclCiopsKeeE2mW9MrZIUY");

        //Edittext non Focusable
        etSource.setFocusable(false);
        etSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Define type
                sType = "source";
                //Initialize Place Field
                List<Place.Field> fields = Arrays.asList(Place.Field.ADDRESS,
                        Place.Field.LAT_LNG);

                //Create Intent
                Intent intent = new Autocomplete.IntentBuilder(
                        AutocompleteActivityMode.OVERLAY,fields
                ).build(AutoDistance.this);

                //start activity result
                startActivityForResult(intent,100);



            }
        });

        //set Edit text non focus
        etDestination.setFocusable(false);
        etDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Define type

                sType = "destination";

                //Initialize Field List
                List<Place.Field> fields = Arrays.asList(Place.Field.ADDRESS,
                        Place.Field.LAT_LNG);
                //Create Intent
                Intent intent = new Autocomplete.IntentBuilder(
                        AutocompleteActivityMode.OVERLAY,fields
                ).build(AutoDistance.this);

                //start activity result
                startActivityForResult(intent,100);
            }
        });

        //set Text on textView
        textView.setText("0.0 Kilometers");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //CheckCondition
        if(requestCode == 100 && resultCode == RESULT_OK){
            //When Success
            //Initialize Place

            Place place = Autocomplete.getPlaceFromIntent(data);
            //Check Condition

            if(sType.equals("source")){
                //When type is source
                //Increase flag value

                flag++;
                //set Address on edit text
                etSource.setText(place.getAddress());
                //Get Latitude & Longitude
                String sSource = String.valueOf(place.getLatLng());
                sSource = sSource.replaceAll("lat/lng: ","");
                sSource = sSource.replace("(","");
                sSource = sSource.replace(")","");
                String[] split = sSource.split(",");

                lat1 = Double.parseDouble(split[0]);
                long1 = Double.parseDouble(split[1]);
            }else{
                //when type is destination
                //increase flag value
                flag++;
                //set address on edit text
                etDestination.setText(place.getAddress());
                //Get longitude and latitude

                String sDestination = String.valueOf(place.getLatLng());
                sDestination = sDestination.replaceAll("lat/lng","");
                sDestination = sDestination.replace("(","");
                sDestination = sDestination.replace(")","");

                String[] split = sDestination.split(",");

                lat2 = Double.parseDouble(split[0]);
                long2 = Double.parseDouble(split[1]);
            }

            //Check Condition
            if(flag >= 2){
                //When flag is greater than and equal to 2
                //calculate distance
                distance(lat1,long1,lat2,long2);
            }
        }else if(requestCode == AutocompleteActivity.RESULT_ERROR){
            //When error
            //Initialize status

            Status status = Autocomplete.getStatusFromIntent(data);
            //Display toast

            Toast.makeText(getApplicationContext(),status.getStatusMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void distance(double lat1, double long1, double lat2, double long2) {
        //Calculate longitude difference

        double longDiff = long1 - long2;

        //Calculate Distance
        double distance = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(longDiff));

        distance = Math.acos(distance);

        //Convert distance radian to degree

        distance = rad2deg(distance);

        //Distance in Miles
        distance = distance * 60 * 1.1515;

        //Distance in Kilometers
        distance = distance * 1.609344;

        //Set distance on text view
        textView.setText(String.format(Locale.US,"%2f Kilometers",distance));

    }

    //Convert radian to degree
    private double rad2deg(double distance) {
        return(distance*180.0 / Math.PI);
    }

    //Convert degree to Radius
    private double deg2rad(double lat1) {
        return(lat1*Math.PI/180.0);
    }

    public void ok(View view) {



        Intent intent = new Intent(this,TakeDistance.class);
        startActivity(intent);
    }
}

