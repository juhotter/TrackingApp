package com.example.trackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class PersonalActivity extends AppCompatActivity  {

    String[] country = { "PALBüro", "PALStudierenmitGehen", "PALGehendStehend", "PALharteArbeit"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);









//weight setzen
        setContentView(R.layout.activity_personal);
        TextView textViewWeight = (TextView) findViewById(R.id.textViewVersion);
        Integer text = MainActivity.db2.getSinglePerson("julian").getWeight();



            textViewWeight.setText(text.toString() + "kg - with Actual Pal " + MainActivity.actualPal);


            TextView textviewpr = (TextView) findViewById(R.id.textViewVersion2);
        textviewpr.setText("Bench:"+MainActivity.onermbench+"\r\nDeadlift:"+MainActivity.onermkreuz+"\r\nSquats:"+MainActivity.onermknie);


        final ImageButton GewichtändernButton = findViewById(R.id.imageView);
        GewichtändernButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                //make the pop up fenster
                final Dialog dialog2 = new Dialog(PersonalActivity.this);
                dialog2.setContentView(R.layout.popup_window3);
                Button dialogButton2 = (Button) dialog2.findViewById(R.id.neuesGewichtspeichern);
                Spinner spinnerActivity = (Spinner) dialog2.findViewById(R.id.spinner1);

                spinnerActivity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        MainActivity.actualPal = MainActivity.actualPal;
                    }

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int pos, long id) {

                    if(pos == 1){
                        MainActivity.actualPal = MainActivity.PALBüro;
                        MainActivity.updateDaylyKalories();
                    }
                        if(pos == 2){
                            MainActivity.actualPal = MainActivity.PALStudierenmitGehen;
                            MainActivity.updateDaylyKalories();
                        }
                        if(pos == 3){
                            MainActivity.actualPal = MainActivity.PALGehendStehend;
                            MainActivity.updateDaylyKalories();
                        }
                        if(pos == 4){
                            MainActivity.actualPal = MainActivity.PALharteArbeit;
                            MainActivity.updateDaylyKalories();
                        }




                        // Your code to do something with the selected item
                    }
                });

                //Creating the ArrayAdapter instance having the country list
                ArrayAdapter aa = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,country);
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //Setting the ArrayAdapter data on the Spinner
                spinnerActivity.setAdapter(aa);












                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen FÜR WEIGHT
                        View parentView = (View) v.getParent();
                        EditText et = (EditText)parentView.findViewById(R.id.neuesGewicht);
                        String text1 = et.getText().toString();
                        if(text1.isEmpty()){
                            int i  = MainActivity.db2.getSinglePerson("julian").getWeight();
                            text1 = Integer.toString(i);
                        }






                        //alte person rausholen
                        Person person = MainActivity.db2.getSinglePerson("julian");
                        person.setWeight(Integer.parseInt(text1));
                        //DB leeren
                        MainActivity.db2.deleteAllPerson();
                        //die Person reinspecihern wieder mit dem ugedaten gewicht
                        MainActivity.db2.addPerson(person);
                        Integer textraus = MainActivity.db2.getSinglePerson("julian").getWeight();
                        textViewWeight.setText(  textraus.toString());

                        dialog2.dismiss();
                        Toast.makeText(getApplicationContext()," Neues Gewicht",Toast.LENGTH_SHORT).show();

                        Integer myweight = MainActivity.db2.getSinglePerson("julian").getWeight();
                        Integer Grundumsatz =  (((int) (66.47 + (13.7 * myweight) + (5 * 180) - (6.8 * 23))));
                        MainActivity.maxKalorien = Grundumsatz.toString();


                        MainActivity.updateDaylyKalories();





                    }

                }




                ) ;
                dialog2.show();

            }});









/*



*/









    }
}