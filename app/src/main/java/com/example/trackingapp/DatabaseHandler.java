package com.example.trackingapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 15;
    private static final String DATABASE_NAME = "MahlzeitDatabase";



    //Table1
    private static final String TABLE_CONTACTS = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_KALORIEN = "Kalorien";




    //Table2
    private static final String TABLE_WORKOUT = "bench";
    private static final String KEY_ID2 = "id2";
    private static final String KEY_BENCH_SETS = "benchsets";
    private static final String KEY_BENCH_SET_NR = "setnumber";



    //Table3
    private static final String TABLE_PERSON = "person";
    private static final String KEY_PERSONNAME = "personname";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_BENCH1RM = "bench1Rm";
    private static final String KEY_DEADLIFTS1RM = "deadlift1Rm";
    private static final String KEY_SQUATSMAX = "squats1Rm";




    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables - beide Tables werden created.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MAHLZEIT_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_KALORIEN + " INTEGER" + ")";



        String CREATE_TABLE_WORKOUT = "CREATE TABLE IF NOT EXISTS " + TABLE_WORKOUT + "("
                + KEY_ID2 + " INTEGER PRIMARY KEY," + KEY_BENCH_SETS + " TEXT,"
                + KEY_BENCH_SET_NR + " INTEGER" + ")";


        String CREATE_TABLE_PERSON = "CREATE TABLE IF NOT EXISTS " + TABLE_PERSON + "("
                + KEY_PERSONNAME + " TEXT," + KEY_WEIGHT + " INTEGER," + KEY_BENCH1RM + " INTEGER,"
                + KEY_DEADLIFTS1RM + " INTEGER," + KEY_SQUATSMAX + " INTEGER" + ")";





        db.execSQL(CREATE_TABLE_WORKOUT);
        db.execSQL(CREATE_MAHLZEIT_TABLE);
        db.execSQL(CREATE_TABLE_PERSON);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);

        // Create tables again
        onCreate(db);
    }

    // code to add the new contact
    void addContact(Mahlzeit mahlzeit) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, mahlzeit.getName());
        values.put(KEY_KALORIEN, mahlzeit.getKalorien());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }



    void addSet(BenchSets benchset) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_BENCH_SETS, benchset.getBenchsets());
        values.put(KEY_BENCH_SET_NR, benchset.getSetNr());

        // Inserting Row
        db.insert(TABLE_WORKOUT, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }



    void addPerson(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PERSONNAME,person.getPersonname());
        values.put(KEY_WEIGHT, person.getWeight());
        values.put(KEY_BENCH1RM, person.getBench1Rm());
        values.put(KEY_DEADLIFTS1RM,person.getDeadlift1Rm());
        values.put(KEY_SQUATSMAX,person.getSquats1Rm());

        // Inserting Row
        db.insert(TABLE_PERSON, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
















    // code to get the single mahlzeit
    Mahlzeit getMahlzeit(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_KALORIEN }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Mahlzeit mahlzeit = new Mahlzeit(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)));
        // return contact
        return mahlzeit;
    }



    BenchSets getSingleBenchSet(int satzzahl) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_WORKOUT, new String[] { KEY_ID2,
                        KEY_BENCH_SETS, KEY_BENCH_SET_NR }, KEY_BENCH_SET_NR + "=?",
                new String[] { String.valueOf(satzzahl) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        BenchSets benchsets = new BenchSets(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)));
        // return contact
        return benchsets;
    }



    Person getSinglePerson(String namevonperson) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PERSON, new String[] { KEY_PERSONNAME,KEY_WEIGHT,
                        KEY_BENCH1RM, KEY_DEADLIFTS1RM,KEY_SQUATSMAX }, KEY_PERSONNAME + "=?",
                new String[] { String.valueOf(namevonperson) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Person searchedPerson = new Person(
                cursor.getString(0),
                Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)),
                        Integer.parseInt(cursor.getString(4)));
        //return Person
        return searchedPerson;
    }








    // code to get all contacts in a list view
    public ArrayList<Mahlzeit> getAllMahlzeiten() {
        ArrayList<Mahlzeit> mahlzeitList = new ArrayList<Mahlzeit>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Mahlzeit mahlzeit = new Mahlzeit();
                mahlzeit.setID(Integer.parseInt(cursor.getString(0)));
                mahlzeit.setName(cursor.getString(1));
                mahlzeit.setKalorien(Integer.parseInt(cursor.getString(2)));
                // Adding contact to list
                mahlzeitList.add(mahlzeit);
            } while (cursor.moveToNext());
        }

        // return contact list
        return mahlzeitList;
    }





    // code to update single set
    public int updateBenchSet(BenchSets benchset) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_BENCH_SETS, benchset.getBenchsets());
        values.put(KEY_BENCH_SET_NR, benchset.getSetNr());

        // updating row
        return db.update(TABLE_WORKOUT, values, KEY_BENCH_SET_NR + " = ?",
                new String[] { String.valueOf(benchset.getSetNr()) });
    }






    // Deleting all mahlzeiten
    public void deleteAllMahlzeiten() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS,null,null);
        db.execSQL("delete from "+ TABLE_CONTACTS);
        db.close();
    }


    // Deleting all contact
    public void deleteAllPerson() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PERSON,null,null);
        db.execSQL("delete from "+ TABLE_PERSON);
        db.close();
    }







    // Deleting  contact
    public void deleteSingleMahlzeit(Mahlzeit mahlzeit) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(mahlzeit.getID()) });
        db.close();
    }






    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}