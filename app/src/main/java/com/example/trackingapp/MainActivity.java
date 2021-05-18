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
    static String maxKalorien = "0";
    static double PALBüro = 1.45;
    static double PALStudierenmitGehen = 1.65;
    static double PALGehendStehend = 1.85;
    static double PALharteArbeit = 2.2;
    static double actualPal = 0.0;
    static Integer onermbench;
    static Integer onermkreuz;
    static Integer onermknie;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db2 = new DatabaseHandler(this);

        //war nur zum ersten befüllen der Datenbank notwendig - m,aybe für neue sätze wieder
        MainActivity.db2.addSet(new BenchSets("5x105",1));
        MainActivity.db2.addSet(new BenchSets("5x105",2));
        MainActivity.db2.addSet(new BenchSets("5x105",3));
        MainActivity.db2.addSet(new BenchSets("5x105",4));
        MainActivity.db2.addSet(new BenchSets("5x105",5));
        MainActivity.db2.addSet(new BenchSets("5x105",6));
        MainActivity.db2.addSet(new BenchSets("5x105",7));
        MainActivity.db2.addSet(new BenchSets("5x105",8));
        MainActivity.db2.addSet(new BenchSets("5x105",9));
        MainActivity.db2.addSet(new BenchSets("5x105",10));
        MainActivity.db2.addSet(new BenchSets("5x105",11));
        MainActivity.db2.addSet(new BenchSets("5x105",12));
        MainActivity.db2.addSet(new BenchSets("5x105",13));
        MainActivity.db2.addSet(new BenchSets("5x105",14));
        MainActivity.db2.addSet(new BenchSets("5x105",15));
        MainActivity.db2.addSet(new BenchSets("5x105",16));
        MainActivity.db2.addSet(new BenchSets("5x105",17));
        MainActivity.db2.addSet(new BenchSets("5x105",18));
        MainActivity.db2.addSet(new BenchSets("5x105",19));
        MainActivity.db2.addSet(new BenchSets("5x105",20));
        MainActivity.db2.addSet(new BenchSets("5x105",21));
        MainActivity.db2.addSet(new BenchSets("5x105",22));
        MainActivity.db2.addSet(new BenchSets("5x105",23));
        MainActivity.db2.addSet(new BenchSets("5x105",24));
        MainActivity.db2.addSet(new BenchSets("5x105",25));
        MainActivity.db2.addSet(new BenchSets("5x105",26));
        MainActivity.db2.addSet(new BenchSets("5x105",27));
        MainActivity.db2.addSet(new BenchSets("5x105",28));
        MainActivity.db2.addSet(new BenchSets("5x105",29));
        MainActivity.db2.addSet(new BenchSets("5x105",30));
        MainActivity.db2.addSet(new BenchSets("5x105",31));
        MainActivity.db2.addSet(new BenchSets("5x105",32));
        MainActivity.db2.addSet(new BenchSets("5x105",33));
        MainActivity.db2.addSet(new BenchSets("5x105",34));
        MainActivity.db2.addSet(new BenchSets("5x105",35));
        MainActivity.db2.addSet(new BenchSets("5x105",36));
        MainActivity.db2.addSet(new BenchSets("5x105",37));
        MainActivity.db2.addSet(new BenchSets("5x105",38));
        MainActivity.db2.addSet(new BenchSets("5x105",39));
        MainActivity.db2.addSet(new BenchSets("5x105",40));
        MainActivity.db2.addSet(new BenchSets("5x105",41));
        MainActivity.db2.addSet(new BenchSets("5x105",42));
        MainActivity.db2.addSet(new BenchSets("5x105",43));
        MainActivity.db2.addSet(new BenchSets("5x105",44));


        String Bench = db2.getSingleBenchSet(2).toString(); // bench set zweites
        String Kreuzheben = db2.getSingleBenchSet(17).toString(); // Kreuzheben zweites Set
        String Kniebuege = db2.getSingleBenchSet(22).toString(); // Kniebeuge zweites Set

        //jetz muss man aus 5x105 zb. das max errechnen
        String SplittedBench[] = Bench.split("x");
        String SplittedKreuzheben[] = Kreuzheben.split("x");
        String SplittedSquats[] = Kniebuege.split("x");


        Integer benchreps =  Integer.parseInt(SplittedBench[0]);
        Integer benchweight =  Integer.parseInt(SplittedBench[1]);
        Integer kreuzreps =  Integer.parseInt(SplittedKreuzheben[0]);
        Integer kreuzweight =  Integer.parseInt(SplittedKreuzheben[1]);
        Integer squatsreps =  Integer.parseInt(SplittedSquats[0]);
        Integer squatsweight =  Integer.parseInt(SplittedSquats[1]);

//jetz 1 RM BERECHNEN UND IN PERSON REINSPIELEN
        onermbench = benchweight+benchweight*benchreps/30;
        onermkreuz = kreuzweight+kreuzweight*kreuzreps/30;
        onermknie = squatsweight+squatsweight*squatsreps/30;


//dummy data for begining
        db2.addPerson(new Person("julian",80,onermbench,onermkreuz,onermknie));




        //gesamtvariable mit 0 instanzieren und dann updatetn auf den aktuellen wert
          sum = new GesamtBerechnungen(0);
          sum.setGesamt();
          sum.getGesamt();


       updateWeightRecords();












//myweight
Integer myweight = MainActivity.db2.getSinglePerson("julian").getWeight();
        Toast.makeText(getApplicationContext()," herausglesen gewicht "+ myweight,Toast.LENGTH_SHORT).show();
Integer Grundumsatz =  (((int) (66.47 + (13.7 * myweight) + (5 * 180) - (6.8 * 23))));
       maxKalorien = Grundumsatz.toString();




        //textview
        setContentView(R.layout.activity_main);
         textView = (TextView) findViewById(R.id.textview);
        textView.setText(sum.toString() + "Grundumsatz " + maxKalorien);














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



updateDaylyKalories();
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
        textView.setText(sum.toString() +
                "\r\nGrundumsatz " +  maxKalorien
         + "\r\nTagesverbrauch: " + (int)(Integer.parseInt(maxKalorien) * actualPal));
    }

public static void updateWeightRecords(){

    String Bench = db2.getSingleBenchSet(2).toString(); // bench set zweites
    String Kreuzheben = db2.getSingleBenchSet(17).toString(); // Kreuzheben zweites Set
    String Kniebuege = db2.getSingleBenchSet(22).toString(); // Kniebeuge zweites Set

    //jetz muss man aus 5x105 zb. das max errechnen
    String SplittedBench[] = Bench.split("x");
    String SplittedKreuzheben[] = Kreuzheben.split("x");
    String SplittedSquats[] = Kniebuege.split("x");


    Integer benchreps =  Integer.parseInt(SplittedBench[0]);
    Integer benchweight =  Integer.parseInt(SplittedBench[1]);
    Integer kreuzreps =  Integer.parseInt(SplittedKreuzheben[0]);
    Integer kreuzweight =  Integer.parseInt(SplittedKreuzheben[1]);
    Integer squatsreps =  Integer.parseInt(SplittedSquats[0]);
    Integer squatsweight =  Integer.parseInt(SplittedSquats[1]);

//jetz 1 RM BERECHNEN UND IN PERSON REINSPIELEN
    onermbench = benchweight+benchweight*benchreps/30;
    onermkreuz = kreuzweight+kreuzweight*kreuzreps/30;
    onermknie = squatsweight+squatsweight*squatsreps/30;


//dummy data for begining
    db2.addPerson(new Person("julian",80,onermbench,onermkreuz,onermknie));

}




}

