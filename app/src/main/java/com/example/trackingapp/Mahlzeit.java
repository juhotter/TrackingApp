
package com.example.trackingapp;
public class Mahlzeit {
    int _id;
    String name;
    int Kalorien;
    public Mahlzeit(){   }
    public Mahlzeit(int id, String name, int Kalorien){
        this._id = id;
        this.name = name;
        this.Kalorien = Kalorien;
    }

    public Mahlzeit(String name, int Kalorien){
        this.name = name;
        this.Kalorien = Kalorien;
    }
    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getKalorien(){
        return this.Kalorien;
    }

    public void setKalorien(int kalorien){
        this.Kalorien = kalorien;
    }


    @Override
    public String toString() {
        return
                name + "\n" +
                 + Kalorien +"kcal"
                ;
    }
}