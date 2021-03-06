package com.example.androidfinalproject;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FlightStatusDbOpen extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "FlightStatusTracker";
    public static final int VERSION_NUM = 2;
    public static final String TABLE_NAME = "Flights";
    public static final String COL_ID = "_id";
    public static final String COL_NUMBER = "NUMBER";
    public static final String COL_STATUS = "STATUS";
    public static final String COL_SPEEDHORIZONTAL = "HORIZONTAL";
    public static final String COL_SPEEDISGROUND = "GROUND";
    public static final String COL_SPEEDVERTICAL = "VERTICAL";
    public static final String COL_ALTITUDE = "ALTITUDE";

    public FlightStatusDbOpen(Activity ctx) {
        //The factory parameter should be null, unless you know a lot about Database Memory management
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    public void onCreate(SQLiteDatabase db){
        //Make sure you put spaces between SQL statements and Java strings:
        db.execSQL("CREATE TABLE " + TABLE_NAME + "( "
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_NUMBER + " TEXT, " + COL_STATUS + " TEXT,"
                + COL_SPEEDHORIZONTAL + " TEXT, " + COL_SPEEDISGROUND + " BOOLEAN, "
                + COL_SPEEDVERTICAL + " TEXT, " +  COL_ALTITUDE + " TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.i("Database upgrade", "Old version:" + oldVersion + " newVersion:" + newVersion);

        //Delete the old table:
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        //Create a new table:
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.i("Database downgrade", "Old version:" + oldVersion + " newVersion:"+newVersion);

        //Delete the old table:
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        //Create a new table:
        onCreate(db);
    }


        /*
           •	The name of the columns in the cursor.
           •	The number of results in the cursor
           •	Each row of results in the cursor.
        */
}
