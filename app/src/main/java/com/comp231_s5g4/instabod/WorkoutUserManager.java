package com.comp231_s5g4.instabod;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.logging.Logger;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

public class WorkoutUserManager extends SQLiteOpenHelper {

    //database name and version
    private static final String DATABASE_NAME = "WorkoutUserDB.db";
    private static final int DATABASE_VERSION = 1;


    // should be set from within main activity
    private static String tableName;
    private static String tableCreatorString;


    public WorkoutUserManager(Context context)
    {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }


    /* Called when the database is created for the first time.
    This is where the creation of tables and the initial population
    of the tables should happen.*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableCreatorString);
    }


    /* Called when the database needs to be upgraded.
    The implementation should use this method to drop tables,
    add tables, or do anything else it needs to upgrade
    to the new schema version.*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }


    /* initialize table names and CREATE TABLE statement called by activity to create a table in the database
    The following arguments should be passed:
    tableName - a String variable which holds the table name
    tableCreatorString - a String variable which holds the CREATE Table statement*/
    public void workoutUserDbInitialize(String tableName, String tableCreatorString)
    {
        this.tableName=tableName;
        this.tableCreatorString=tableCreatorString;

    }

    /*
    Create Read and Update Operations
    This method is called by the activity to add a row in the table
    The following arguments should be passed:
    values - a ContentValues object that holds row values */
    public boolean addWorkoutUserRow  (ContentValues values) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        long nr= db.insert(tableName, null, values);
        db.close();
        return nr> -1;
    }

    /* This method returns a task object which holds the table row with the given id
    The following argument should be passed:
    id - an Object which holds the primary key value
    fieldName - the  name of the primary key field */
    public WorkoutUser getWorkoutUserById(Object id, String fieldName) throws Exception{
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select * from " + tableName + " where "+ fieldName + "="+String.valueOf(id)+"", null );
        WorkoutUser workoutUser= new WorkoutUser();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();

            workoutUser.setUserName(cursor.getInt(0));
            workoutUser.setPassword(cursor.getString(1));
            workoutUser.setAge(cursor.getInt(2));
            workoutUser.setGender(cursor.getString(3));
            workoutUser.setSecurityQ1(cursor.getString(4));
            workoutUser.setSecurityA1(cursor.getString(5));
            workoutUser.setSecurityQ2(cursor.getString(6));
            workoutUser.setSecurityA2(cursor.getString(7));
            workoutUser.setHeight(cursor.getDouble(8));
            workoutUser.setWaistCircumference(cursor.getDouble(9));
            workoutUser.setRfm(cursor.getInt(10));
            workoutUser.setPushUpScore(cursor.getInt(11));
            workoutUser.setSitUpScore(cursor.getInt(12));
            workoutUser.setFrequencyOfExercise(cursor.getInt(13));
            cursor.close();
        } else {
            workoutUser = null;
        }
        db.close();
        return workoutUser;
    }


    /* The following argument should be passed:
    id - an Object which holds the primary key value
    fieldName - the  name of the primary key field
    values - a ContentValues object that holds row values */
    public boolean updateWorkoutUserRow (Object id, String fieldName, ContentValues values) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        //
        int nr = db.update(tableName, values, fieldName + " = ? ", new String[]{String.valueOf(id)});
        return nr > 0;
    }


    /* The following method is for getting the list of all the records
    *  in our WorkoutUser table */
    public ArrayList<WorkoutUser> getAllRecords() {
        ArrayList<WorkoutUser> workoutUserArrayList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + tableName;
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                if (cursor.moveToFirst()) {
                    do {
                        WorkoutUser workoutUser = new WorkoutUser();
                        workoutUser.setUserName(cursor.getInt(0));
                        workoutUser.setPassword(cursor.getString(1));
                        workoutUser.setAge(cursor.getInt(2));
                        workoutUser.setGender(cursor.getString(3));
                        workoutUser.setSecurityQ1(cursor.getString(4));
                        workoutUser.setSecurityA1(cursor.getString(5));
                        workoutUser.setSecurityQ2(cursor.getString(6));
                        workoutUser.setSecurityA2(cursor.getString(7));
                        workoutUser.setHeight(cursor.getDouble(8));
                        workoutUser.setWaistCircumference(cursor.getDouble(9));
                        workoutUser.setRfm(cursor.getInt(10));
                        workoutUser.setPushUpScore(cursor.getInt(11));
                        workoutUser.setSitUpScore(cursor.getInt(12));
                        workoutUser.setFrequencyOfExercise(cursor.getInt(13));
                        workoutUserArrayList.add(workoutUser);
                    } while (cursor.moveToNext());
                }
            } finally {
                try { cursor.close(); } catch (Exception ignore) {}
            }

        } finally {
            try { db.close(); } catch (Exception ignore) {}
        }
        return workoutUserArrayList;
    }
}
