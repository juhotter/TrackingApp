package com.example.trackingapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.provider.SyncStateContract;
import android.text.Editable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.os.CountDownTimer;
public class WorkoutActivity extends AppCompatActivity {

    final Context context = this;
    public int counter;


    CountDownTimer timer;

    CheckBox check1;
    CheckBox check2;
    CheckBox check3;
    CheckBox check4;
    CheckBox check5;
    CheckBox check6;
    CheckBox checkdips1;
    CheckBox checkdips2;
    CheckBox checkdips3;
    CheckBox checkdips4;
    CheckBox checkdips5;
    CheckBox checkschulter1;
    CheckBox checkschulter2;
    CheckBox checkschulter3;
    CheckBox checkschulter4;
    CheckBox checkheben1;
    CheckBox checkheben2;
    CheckBox checkheben3;
    CheckBox checkheben4;
    CheckBox checkheben5;
    CheckBox checkbeugen1;
    CheckBox checkbeugen2;
    CheckBox checkbeugen3;
    CheckBox checkbeugen4;
    CheckBox checkbeugen5;
    CheckBox checkbeugen6;
    CheckBox checkRudern1;
    CheckBox checkRudern2;
    CheckBox checkRudern3;
    CheckBox checkRudern4;
    CheckBox checkRudern5;
    CheckBox checkRudern6;
    CheckBox checkKlimmzug1;
    CheckBox checkKlimmzug2;
    CheckBox checkKlimmzug3;
    CheckBox checkKlimmzug4;
    CheckBox checkKlimmzug5;
    CheckBox checkKlimmzug6;
    CheckBox checkCrunshes1;
    CheckBox checkCrunshes2;
    CheckBox checkCrunshes3;
    CheckBox checkCrunshes4;
    CheckBox checkCrunshes5;
    CheckBox checkCrunshes6;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_aktivity);




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





         check1 = (CheckBox)findViewById(R.id.check1);
         check2 = (CheckBox)findViewById(R.id.check2);
         check3 = (CheckBox)findViewById(R.id.check3);
        check4 = (CheckBox)findViewById(R.id.check4);
        check5 = (CheckBox)findViewById(R.id.check5);
        check6 = (CheckBox)findViewById(R.id.check6);
        checkdips1 = (CheckBox)findViewById(R.id.checkdips1);
        checkdips2 = (CheckBox)findViewById(R.id.checkdips2);
        checkdips3 = (CheckBox)findViewById(R.id.checkdips3);
        checkdips4 = (CheckBox)findViewById(R.id.checkdips4);
        checkdips5 = (CheckBox)findViewById(R.id.checkdips5);
        checkschulter1 = (CheckBox)findViewById(R.id.checkschulter1);
        checkschulter2 = (CheckBox)findViewById(R.id.checkschulter2);
        checkschulter3 = (CheckBox)findViewById(R.id.checkschulter3);
        checkschulter4 = (CheckBox)findViewById(R.id.checkschulter4);
        checkbeugen1 = (CheckBox)findViewById(R.id.checkbeugen1);
        checkbeugen2 = (CheckBox)findViewById(R.id.checkbeugen2);
        checkbeugen3 = (CheckBox)findViewById(R.id.checkbeugen3);
        checkbeugen4 = (CheckBox)findViewById(R.id.checkbeugen4);
        checkbeugen5 = (CheckBox)findViewById(R.id.checkbeugen5);
        checkbeugen6 = (CheckBox)findViewById(R.id.checkbeugen6);
        checkheben1= (CheckBox)findViewById(R.id.checkheben1);
        checkheben2= (CheckBox)findViewById(R.id.checkheben2);
        checkheben3= (CheckBox)findViewById(R.id.checkheben3);
        checkheben4= (CheckBox)findViewById(R.id.checkheben4);
        checkheben5= (CheckBox)findViewById(R.id.checkheben5);
        checkRudern1 = (CheckBox)findViewById(R.id.rudern1);
        checkRudern2 = (CheckBox)findViewById(R.id.rudern2);
        checkRudern3 = (CheckBox)findViewById(R.id.rudern3);
        checkRudern4 = (CheckBox)findViewById(R.id.rudern4);
        checkRudern5 = (CheckBox)findViewById(R.id.rudern5);
        checkRudern6 = (CheckBox)findViewById(R.id.rudern6);
        checkKlimmzug1 = (CheckBox)findViewById(R.id.klimmzüge1);
        checkKlimmzug2 = (CheckBox)findViewById(R.id.klimmzüge2);
        checkKlimmzug3 = (CheckBox)findViewById(R.id.klimmzüge3);
        checkKlimmzug4 = (CheckBox)findViewById(R.id.klimmzüge4);
        checkKlimmzug5 = (CheckBox)findViewById(R.id.klimmzüge5);
        checkKlimmzug6 = (CheckBox)findViewById(R.id.klimmzüge6);
        checkCrunshes1 = (CheckBox)findViewById(R.id.crunshes1);
        checkCrunshes2 = (CheckBox)findViewById(R.id.crunshes2);
        checkCrunshes3 = (CheckBox)findViewById(R.id.crunshes3);
        checkCrunshes4 = (CheckBox)findViewById(R.id.crunshes4);
        checkCrunshes5 = (CheckBox)findViewById(R.id.crunshes5);
        checkCrunshes6 = (CheckBox)findViewById(R.id.crunshes6);









        check1.setText(MainActivity.db2.getSingleBenchSet(1).toString());
        check2.setText(MainActivity.db2.getSingleBenchSet(2).toString());
        check3.setText(MainActivity.db2.getSingleBenchSet(3).toString());
        check4.setText(MainActivity.db2.getSingleBenchSet(4).toString());
        check5.setText(MainActivity.db2.getSingleBenchSet(5).toString());
        check6.setText(MainActivity.db2.getSingleBenchSet(6).toString());
        checkdips1.setText(MainActivity.db2.getSingleBenchSet(7).toString());
        checkdips2.setText(MainActivity.db2.getSingleBenchSet(8).toString());
        checkdips3.setText(MainActivity.db2.getSingleBenchSet(9).toString());
        checkdips4.setText(MainActivity.db2.getSingleBenchSet(10).toString());
        checkdips5.setText(MainActivity.db2.getSingleBenchSet(11).toString());
        checkschulter1.setText(MainActivity.db2.getSingleBenchSet(12).toString());
        checkschulter2.setText(MainActivity.db2.getSingleBenchSet(13).toString());
        checkschulter3.setText(MainActivity.db2.getSingleBenchSet(14).toString());
        checkschulter4.setText(MainActivity.db2.getSingleBenchSet(15).toString());


        checkheben1.setText(MainActivity.db2.getSingleBenchSet(16).toString());
        checkheben2.setText(MainActivity.db2.getSingleBenchSet(17).toString());
        checkheben3.setText(MainActivity.db2.getSingleBenchSet(18).toString());
        checkheben4.setText(MainActivity.db2.getSingleBenchSet(19).toString());
        checkheben5.setText(MainActivity.db2.getSingleBenchSet(20).toString());

        checkbeugen1.setText(MainActivity.db2.getSingleBenchSet(21).toString());
        checkbeugen2.setText(MainActivity.db2.getSingleBenchSet(22).toString());
        checkbeugen3.setText(MainActivity.db2.getSingleBenchSet(23).toString());
        checkbeugen4.setText(MainActivity.db2.getSingleBenchSet(24).toString());
        checkbeugen5.setText(MainActivity.db2.getSingleBenchSet(25).toString());
        checkbeugen6.setText(MainActivity.db2.getSingleBenchSet(26).toString());


        checkRudern1.setText(MainActivity.db2.getSingleBenchSet(27).toString());
        checkRudern2.setText(MainActivity.db2.getSingleBenchSet(28).toString());
        checkRudern3.setText(MainActivity.db2.getSingleBenchSet(29).toString());
        checkRudern4.setText(MainActivity.db2.getSingleBenchSet(30).toString());
        checkRudern5.setText(MainActivity.db2.getSingleBenchSet(31).toString());
        checkRudern6.setText(MainActivity.db2.getSingleBenchSet(32).toString());



        checkKlimmzug1.setText(MainActivity.db2.getSingleBenchSet(33).toString());
        checkKlimmzug2.setText(MainActivity.db2.getSingleBenchSet(34).toString());
        checkKlimmzug3.setText(MainActivity.db2.getSingleBenchSet(35).toString());
        checkKlimmzug4.setText(MainActivity.db2.getSingleBenchSet(36).toString());
        checkKlimmzug5.setText(MainActivity.db2.getSingleBenchSet(37).toString());
        checkKlimmzug6.setText(MainActivity.db2.getSingleBenchSet(38).toString());

        checkCrunshes1.setText(MainActivity.db2.getSingleBenchSet(39).toString());
        checkCrunshes2.setText(MainActivity.db2.getSingleBenchSet(40).toString());
        checkCrunshes3.setText(MainActivity.db2.getSingleBenchSet(41).toString());
        checkCrunshes4.setText(MainActivity.db2.getSingleBenchSet(42).toString());
        checkCrunshes5.setText(MainActivity.db2.getSingleBenchSet(43).toString());
        checkCrunshes6.setText(MainActivity.db2.getSingleBenchSet(44).toString());










       Button button_countdown = (Button) findViewById(R.id.countdownbutton);
        TextView textView= (TextView) findViewById(R.id.timer);
        button_countdown.setOnClickListener(new View.OnClickListener()
        {





            @Override
            public void onClick(View v) {


                ProgressBar mProgressBar=(ProgressBar)findViewById(R.id.progressBar);
                mProgressBar.setProgress(0);
                mProgressBar.setMax(240);


                if (timer != null) {
                    timer.cancel();
                }
                 timer  = new CountDownTimer(240000, 1000){





                    public void onTick(long millisUntilFinished){
                        int seconds = (int) (millisUntilFinished / 1000) % 60 ;
                        int minutes = (int) ((millisUntilFinished / (1000*60)) % 60);
                        mProgressBar.setProgress((int)  (millisUntilFinished/1000));


                        textView.setText("Time Left:  " + String.format("%02d",minutes)+":" +  String.format("%02d",seconds) );




                    }
                    public  void onFinish(){

                        textView.setText("LETS GO AGAIN!!");

                        mProgressBar.setProgress(0);
                        mProgressBar.setMax(240);



                        NotificationManager mNotificationManager =
                                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            NotificationChannel channel = new NotificationChannel("YOUR_CHANNEL_ID",
                                    "YOUR_CHANNEL_NAME",
                                    NotificationManager.IMPORTANCE_DEFAULT);
                            channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DESCRIPTION");
                            mNotificationManager.createNotificationChannel(channel);
                        }
                        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "YOUR_CHANNEL_ID")
                                .setOnlyAlertOnce(true)
                                .setContentTitle("Pause Done")
                                .setContentText("Your rest is over bro")
                                .setSmallIcon(R.drawable.eatbig)
                        .setSound(soundUri)
                                ; //This sets the sound to play


                        mNotificationManager.notify(0, mBuilder.build());






                    }
                }.start();

            }
        });







//CHECK1LISTENER
        check1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text1 = et.getText().toString();

                       //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text1,1));
                        check1.setText(MainActivity.db2.getSingleBenchSet(1).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});










//CHECK2 LISTENER
        check2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);



                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et2 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text2 = et2.getText().toString();

                        //Datenbankinhalt updaten checkText updatetn
                        MainActivity.db2.updateBenchSet(new BenchSets(text2,2));
                        check2.setText(MainActivity.db2.getSingleBenchSet(2).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(),"set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});




        check3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et3 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text3 = et3.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text3,3));
                        check3.setText(MainActivity.db2.getSingleBenchSet(3).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});



        check4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et4 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text4 = et4.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text4,4));
                        check4.setText(MainActivity.db2.getSingleBenchSet(4).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});



        check5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et5 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text5 = et5.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text5,5));
                        check5.setText(MainActivity.db2.getSingleBenchSet(5).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});





        check6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,6));
                        check6.setText(MainActivity.db2.getSingleBenchSet(6).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});




        checkdips1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,7));
                        checkdips1.setText(MainActivity.db2.getSingleBenchSet(7).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});




        checkdips2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,8));
                        checkdips2.setText(MainActivity.db2.getSingleBenchSet(8).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});



        checkdips3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,9));
                        checkdips3.setText(MainActivity.db2.getSingleBenchSet(9).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});


        checkdips4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,10));
                        checkdips4.setText(MainActivity.db2.getSingleBenchSet(10).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});



        checkdips5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,11));
                        checkdips5.setText(MainActivity.db2.getSingleBenchSet(11).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});


        checkschulter1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,12));
                        checkschulter1.setText(MainActivity.db2.getSingleBenchSet(12).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});





        checkschulter2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,13));
                        checkschulter2.setText(MainActivity.db2.getSingleBenchSet(13).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});


        checkschulter3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,14));
                        checkschulter3.setText(MainActivity.db2.getSingleBenchSet(14).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});


        checkschulter4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,15));
                        checkschulter4.setText(MainActivity.db2.getSingleBenchSet(15).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});




        checkheben1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,16));
                        checkheben1.setText(MainActivity.db2.getSingleBenchSet(16).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});



        checkheben2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,17));
                        checkheben2.setText(MainActivity.db2.getSingleBenchSet(17).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});

        checkheben3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,18));
                        checkheben3.setText(MainActivity.db2.getSingleBenchSet(18).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});



        checkheben4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,19));
                        checkheben4.setText(MainActivity.db2.getSingleBenchSet(19).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});

        checkheben5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,20));
                        checkheben5.setText(MainActivity.db2.getSingleBenchSet(20).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});




        checkbeugen1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,21));
                        checkbeugen1.setText(MainActivity.db2.getSingleBenchSet(21).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});



        checkbeugen2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,22));
                        checkbeugen2.setText(MainActivity.db2.getSingleBenchSet(22).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});



        checkbeugen3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,23));
                        checkbeugen3.setText(MainActivity.db2.getSingleBenchSet(23).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});



        checkbeugen4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,24));
                        checkbeugen4.setText(MainActivity.db2.getSingleBenchSet(24).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});


        checkbeugen5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,25));
                        checkbeugen5.setText(MainActivity.db2.getSingleBenchSet(25).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});




        checkbeugen6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,26));
                        checkbeugen6.setText(MainActivity.db2.getSingleBenchSet(26).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});




        checkRudern1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,27));
                        checkRudern1.setText(MainActivity.db2.getSingleBenchSet(27).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});


        checkRudern2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,28));
                        checkRudern2.setText(MainActivity.db2.getSingleBenchSet(28).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});

        checkRudern3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,29));
                        checkRudern3.setText(MainActivity.db2.getSingleBenchSet(29).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});



        checkRudern4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,30));
                        checkRudern4.setText(MainActivity.db2.getSingleBenchSet(30).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});


        checkRudern5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,31));
                        checkRudern5.setText(MainActivity.db2.getSingleBenchSet(31).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});


        checkRudern6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,32));
                        checkRudern6.setText(MainActivity.db2.getSingleBenchSet(32).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});






        checkKlimmzug1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,33));
                        checkKlimmzug1.setText(MainActivity.db2.getSingleBenchSet(33).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});


        checkKlimmzug2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,34));
                        checkKlimmzug2.setText(MainActivity.db2.getSingleBenchSet(34).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});

        checkKlimmzug3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,35));
                        checkKlimmzug3.setText(MainActivity.db2.getSingleBenchSet(35).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});



        checkKlimmzug4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,36));
                        checkKlimmzug4.setText(MainActivity.db2.getSingleBenchSet(36).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});


        checkKlimmzug5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,37));
                        checkKlimmzug5.setText(MainActivity.db2.getSingleBenchSet(37).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});



        checkKlimmzug6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,38));
                        checkKlimmzug6.setText(MainActivity.db2.getSingleBenchSet(38).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});





        checkCrunshes1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,39));
                        checkCrunshes1.setText(MainActivity.db2.getSingleBenchSet(39).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});


        checkCrunshes2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,40));
                        checkCrunshes2.setText(MainActivity.db2.getSingleBenchSet(40).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});


        checkCrunshes3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,41));
                        checkCrunshes3.setText(MainActivity.db2.getSingleBenchSet(41).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});

        checkCrunshes4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,42));
                        checkCrunshes4.setText(MainActivity.db2.getSingleBenchSet(42).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});


        checkCrunshes5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //make the pop up fenster
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_window);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                //wenn das Häckein geklickt wird
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //eingegeben Text holen
                        View parentView = (View) v.getParent();
                        EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                        String text6 = et6.getText().toString();

                        //Datenbankinhalt updaten und check updaten
                        MainActivity.db2.updateBenchSet(new BenchSets(text6,43));
                        checkCrunshes5.setText(MainActivity.db2.getSingleBenchSet(43).toString());

                        dialog.dismiss();
                        Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }});
                checkCrunshes6.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        //make the pop up fenster
                        final Dialog dialog = new Dialog(context);
                        dialog.setContentView(R.layout.popup_window);
                        Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);

                        //wenn das Häckein geklickt wird
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                //eingegeben Text holen
                                View parentView = (View) v.getParent();
                                EditText et6 = (EditText)parentView.findViewById(R.id.neuerrecord);
                                String text6 = et6.getText().toString();

                                //Datenbankinhalt updaten und check updaten
                                MainActivity.db2.updateBenchSet(new BenchSets(text6,44));
                                checkCrunshes6.setText(MainActivity.db2.getSingleBenchSet(44).toString());

                                dialog.dismiss();
                                Toast.makeText(getApplicationContext()," set geschafft..!!",Toast.LENGTH_SHORT).show();
                            }
                        });
                        dialog.show();











            }});


















//ACHTUNG ENDKLAMMERN
    }




}



