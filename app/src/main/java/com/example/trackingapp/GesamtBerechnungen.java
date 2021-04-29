package com.example.trackingapp;

import java.util.List;

public class GesamtBerechnungen {


    public GesamtBerechnungen(Integer gesamt) {
        this.gesamt = gesamt;
    }

    Integer gesamt = 0;


    @Override
    public String toString() {
        return "Heute hast du bereits " +
                  gesamt + " Kalorien gegessen "
                ;
    }

    public Integer getGesamt() {
        return gesamt;
    }

    public void setGesamt() {
        gesamt = 0;
        List<Mahlzeit> mahlzeiten = MainActivity.db2.getAllMahlzeiten();
        for (Mahlzeit mahlzeit : mahlzeiten) {
            gesamt = gesamt + mahlzeit.getKalorien();

        }

    }
}