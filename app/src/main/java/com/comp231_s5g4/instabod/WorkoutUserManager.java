package com.comp231_s5g4.instabod;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WorkoutUserManager extends SQLiteOpenHelper {

    //database name and version
    private static final String DATABASE_NAME = "WorkoutUserDB.db";
    private static final int DATABASE_VERSION = 1;


    // should be set from within main activity
    private static String tableName;
    private static String tableCreatorString;


    //The following Table_Name and the TableCreatorString String needs to be called inside the Activity
    //private final static String TABLE_NAME = "WorkoutUser";
    /*private static final String tableCreatorString =
            "CREATE TABLE "+ TABLE_NAME + " (username integer primary key, password text, age integer, gender text, securityQuestion1 text, securityAnswer1 text, " +
                    "securityQuestion2 text, securityAnswer2 text, height numeric, waistCircumference numeric, rfm numeric," +
                    "pushUpScore integer, sitUpScore integer, frequencyOfExercise integer);";
     */


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
        Cursor cursor =  db.rawQuery( "select * from " + tableName + " where "+ fieldName + "='"+String.valueOf(id)+"'", null );
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
}
