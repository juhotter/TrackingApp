package com.example.trackingapp;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;


public class MainActivity extends AppCompatActivity  {
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    static DatabaseHandler db2;
     static ArrayAdapter adapter;
    static GesamtBerechnungen sum;
    static TextView textView;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db2 = new DatabaseHandler(this);

        //gesamtvariable mit 0 instanzieren und dann updatetn auf den aktuellen wert
          sum = new GesamtBerechnungen(0);
          sum.setGesamt();
          sum.getGesamt();







        //textview
        setContentView(R.layout.activity_main);
         textView = (TextView) findViewById(R.id.textview);
        textView.setText(sum.toString());














        List<Mahlzeit> mahlzeitvorlöschen = db2.getAllMahlzeiten();






         adapter = new ArrayAdapter(this, R.layout.activity_listview, mahlzeitvorlöschen) {
        };
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);


//löschen von
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mahlzeit item = mahlzeitvorlöschen.get(position);

                //WENN AUF ITEM GECLICKT WIRD WIRD POPUP FENSTER GEMACHT
                //make the pop up fenster
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.popup_window2);
                Button yesButton = (Button) dialog.findViewById(R.id.yesButton);



                //WENN IN POPUP FENSTER DANN YES GEKLCIKT WIRD WIRD GESPEICHERT
                yesButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {



                        //aus der adapterliste löschen
                        mahlzeitvorlöschen.remove(item);

                        //aus der datenbank löschen
                        db2.deleteSingleMahlzeit(item);
                        adapter.notifyDataSetChanged();

                        updateDaylyKalories();




                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Gelöscht!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});






/*
        final Button button2 = findViewById(R.id.deleteButton);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

//jetz wird es gelöscht und der adapter musss geupdatet werden.
                db2.deleteAllMahlzeiten();
                reloadAllData();
                updateDaylyKalories();


            }});
*/

        //ALARM
        long t = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        if (t <= calendar.getTimeInMillis()) {
            //calendar.add(Calendar.DATE, 6); //add 6 days.
            Intent intent1 = new Intent(MainActivity.this, AlarmHandler.class);
            intent1.setAction("NOTE");
            PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager am = (AlarmManager) MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            //am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

            Toast.makeText(getApplicationContext(),"ALLES GELÖSCHT - NEW DAY!!",Toast.LENGTH_SHORT).show();


        }

        else{

        }








        final ImageButton button = findViewById(R.id.button);
     button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Code here executes on main thread after user presses button
            Intent explicitIntent = new Intent(MainActivity.this, TrackActivity.class);
            explicitIntent.putExtra(Intent.EXTRA_TEXT, "Diese Daten empfängt die andere Activity.");
            startActivity(explicitIntent);



        }
    });





        final ImageButton personalButton = findViewById(R.id.personals);
        personalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent explicitIntent2 = new Intent(MainActivity.this, PersonalActivity.class);
                explicitIntent2.putExtra(Intent.EXTRA_TEXT, "Diese Daten empfängt die andere Activity.");
                startActivity(explicitIntent2);



            }
        });














        final ImageButton workoutbutton = findViewById(R.id.workoutPlan);
        workoutbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button




                Intent explicitIntent = new Intent(MainActivity.this, WorkoutActivity.class);
                explicitIntent.putExtra(Intent.EXTRA_TEXT, "Diese Daten empfängt die andere Activity.");
                startActivity(explicitIntent);



            }
        });




}




     static public void reloadAllData(){

        List<Mahlzeit> mahlzeitnachloeschen = db2.getAllMahlzeiten();
        // update data in our adapter
        adapter.clear();
        adapter.addAll(mahlzeitnachloeschen);
        // fire the event
        adapter.notifyDataSetChanged();
    }

    static public void updateDaylyKalories(){
        sum.setGesamt();
        textView.setText(sum.toString());
    }






}

