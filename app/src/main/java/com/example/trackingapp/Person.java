package com.example.trackingapp;

public class Person {


    int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBench1Rm() {
        return bench1Rm;
    }

    public void setBench1Rm(int bench1Rm) {
        this.bench1Rm = bench1Rm;
    }

    public int getDeadlift1Rm() {
        return deadlift1Rm;
    }

    public void setDeadlift1Rm(int deadlift1Rm) {
        this.deadlift1Rm = deadlift1Rm;
    }

    public int getSquats1Rm() {
        return squats1Rm;
    }

    public void setSquats1Rm(int squats1Rm) {
        this.squats1Rm = squats1Rm;
    }

    public Person(int weight, int bench1Rm, int deadlift1Rm, int squats1Rm) {
        this.weight = weight;
        this.bench1Rm = bench1Rm;
        this.deadlift1Rm = deadlift1Rm;
        this.squats1Rm = squats1Rm;
    }

    int bench1Rm;
    int deadlift1Rm;
    int squats1Rm;




}
