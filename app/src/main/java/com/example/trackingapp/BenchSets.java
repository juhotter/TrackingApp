package com.example.trackingapp;

public class BenchSets {


//tescommit

    public String getBenchsets() {
        return Benchsets;
    }

    public int get_id() {
        return _id;
    }




    public BenchSets() {

    }



    public void set_id(int _id) {
        this._id = _id;
    }

    int _id;
    public void setBenchsets(String benchsets) {
        Benchsets = benchsets;
    }

    String Benchsets;

    public BenchSets(String benchsets, int setNr) {
        Benchsets = benchsets;
        SetNr = setNr;
    }

    public BenchSets(int _id, String benchsets, int setNr) {
        this._id = _id;
        Benchsets = benchsets;
        SetNr = setNr;
    }

    public int getSetNr() {
        return SetNr;
    }

    public void setSetNr(int setNr) {
        SetNr = setNr;
    }

    int SetNr;

    @Override
    public String toString() {
        return

                Benchsets
                ;
    }

}
