package com.example.trackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class TrackActivity extends AppCompatActivity {
    public static final String LOG_TAG = TrackActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);



        final ImageButton speicherButton = findViewById(R.id.saveinDatabaseButton);
        speicherButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                EditText et = (EditText)findViewById(R.id.Eingabename);
                String text = et.getText().toString();

                EditText et2 = (EditText)findViewById(R.id.EingabeKalorien);
                String text2 = et2.getText().toString();



if(TextUtils.isEmpty(text)){
    et.setError("Du musst was eingeben");
    return;
}

                if(TextUtils.isEmpty(text2)){
                    et2.setError("Du musst was eingeben");
                    return;
                }
                Toast.makeText(getApplicationContext()," geadded..!!",Toast.LENGTH_SHORT).show();
                MainActivity.db2.addContact(new Mahlzeit(text, Integer.parseInt(text2)));


                //jetz bei der Main den update button ausführen
                MainActivity.reloadAllData();
                MainActivity.updateDaylyKalories();




            }
        });





    }


}