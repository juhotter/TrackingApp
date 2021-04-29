package com.example.trackingapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

public class AlarmHandler extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Intent scheduledIntent = new Intent(context, MainActivity.class);


        MainActivity.db2.deleteAllMahlzeiten();
        MainActivity.reloadAllData();
        MainActivity.updateDaylyKalories();
        context.startService(scheduledIntent);
        Toast.makeText(context.getApplicationContext()," ALLES WIEDER GELÖSCHT BRO",Toast.LENGTH_SHORT).show();
    }
}