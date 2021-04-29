package com.example.trackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class PersonalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();


int myweight = 76;
editor.putInt("myweight",myweight);
        editor.commit();


        TextView textViewGewicht = (TextView) findViewById(R.id.textViewVersion);
        textViewGewicht.setText(pref.getInt("myweight",-1));










    }
}