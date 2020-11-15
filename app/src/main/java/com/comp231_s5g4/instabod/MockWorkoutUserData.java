package com.comp231_s5g4.instabod;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import static com.comp231_s5g4.instabod.WorkoutUser.convertUsernameToUniqueId;

public class MockWorkoutUserData {
    private static WorkoutUserManager workoutUserManager;
    private static Context context;

    /* Following are the mock users created for the testing purposes
    *   This is for one time use only,
    *   calling them again and again can throw exceptions due to the redundancy check
    *   in our SQL Lite table
    * */
    public static void firstWorkoutUser(){
        workoutUserManager = new WorkoutUserManager(context);
        int workoutUserId = convertUsernameToUniqueId("userM1");

        ContentValues contentValues = new ContentValues();
        contentValues.put("username",workoutUserId);
        contentValues.put("password","Iamtheuser112");
        contentValues.put("age","20");
        contentValues.put("gender","Male");
        contentValues.put("securityQuestion1","What is the name of your first pet?");
        contentValues.put("securityAnswer1","First Pet");
        contentValues.put("securityQuestion2","What is your favourite movie");
        contentValues.put("securityAnswer2","Johny English");
        contentValues.put("height",176.5);
        contentValues.put("waistCircumference",76.2);
        contentValues.put("rfm",17.67);
        contentValues.put("pushUpScore",54);
        contentValues.put("sitUpScore",49);
        contentValues.put("frequencyOfExercise",5);
        try {
            workoutUserManager.addWorkoutUserRow(contentValues);
        }
        catch(Exception exception)
        {
            Log.i("Error: ",exception.getMessage());
        }
    }

    public static void secondWorkoutUser(){
        workoutUserManager = new WorkoutUserManager(context);
        int workoutUserId = convertUsernameToUniqueId("userM2");

        ContentValues contentValues = new ContentValues();
        contentValues.put("username",workoutUserId);
        contentValues.put("password","Iamtheuser112");
        contentValues.put("age","35");
        contentValues.put("gender","Male");
        contentValues.put("securityQuestion1","What is the name of your first pet?");
        contentValues.put("securityAnswer1","Puppy");
        contentValues.put("securityQuestion2","What is your favourite movie");
        contentValues.put("securityAnswer2","unknown");
        contentValues.put("height",190.0);
        contentValues.put("waistCircumference",91.44);
        contentValues.put("rfm",22.44);
        contentValues.put("pushUpScore",20);
        contentValues.put("sitUpScore",20);
        contentValues.put("frequencyOfExercise",1);
        try {
            workoutUserManager.addWorkoutUserRow(contentValues);
        }
        catch(Exception exception)
        {
            Log.i("Error: ",exception.getMessage());
        }
    }

    public static void thirdWorkoutUser(){
        workoutUserManager = new WorkoutUserManager(context);
        int workoutUserId = convertUsernameToUniqueId("userF1");

        ContentValues contentValues = new ContentValues();
        contentValues.put("username",workoutUserId);
        contentValues.put("password","Iamtheuser112");
        contentValues.put("age","35");
        contentValues.put("gender","Female");
        contentValues.put("securityQuestion1","What is the name of your first pet?");
        contentValues.put("securityAnswer1","Snow");
        contentValues.put("securityQuestion2","What is your favourite movie");
        contentValues.put("securityAnswer2","every single movie");
        contentValues.put("height",152.4);
        contentValues.put("waistCircumference",91.44);
        contentValues.put("rfm",42.67);
        contentValues.put("pushUpScore",10);
        contentValues.put("sitUpScore",5);
        contentValues.put("frequencyOfExercise",0);
        try {
            workoutUserManager.addWorkoutUserRow(contentValues);
        }
        catch(Exception exception)
        {
            Log.i("Error: ",exception.getMessage());
        }
    }

    public static void forthWorkoutUser(){
        workoutUserManager = new WorkoutUserManager(context);
        int workoutUserId = convertUsernameToUniqueId("userF2");

        ContentValues contentValues = new ContentValues();
        contentValues.put("username",workoutUserId);
        contentValues.put("password","Iamtheuser112");
        contentValues.put("age","19");
        contentValues.put("gender","Female");
        contentValues.put("securityQuestion1","What is the name of your first pet?");
        contentValues.put("securityAnswer1","First Pet");
        contentValues.put("securityQuestion2","What is your favourite movie");
        contentValues.put("securityAnswer2","Johny English");
        contentValues.put("height",167.64);
        contentValues.put("waistCircumference",71.12);
        contentValues.put("rfm",28.86);
        contentValues.put("pushUpScore",30);
        contentValues.put("sitUpScore",15);
        contentValues.put("frequencyOfExercise",3);
        try {
            workoutUserManager.addWorkoutUserRow(contentValues);
        }
        catch(Exception exception)
        {
            Log.i("Error: ",exception.getMessage());
        }
    }

    public static void fifthWorkoutUser(){
        workoutUserManager = new WorkoutUserManager(context);
        int workoutUserId = convertUsernameToUniqueId("userF3");

        ContentValues contentValues = new ContentValues();
        contentValues.put("username",workoutUserId);
        contentValues.put("password","Thef3user114");
        contentValues.put("age","65");
        contentValues.put("gender","Female");
        contentValues.put("securityQuestion1","What is the name of your first pet?");
        contentValues.put("securityAnswer1","Bell");
        contentValues.put("securityQuestion2","What is your favourite movie");
        contentValues.put("securityAnswer2","nothing");
        contentValues.put("height",125.27);
        contentValues.put("waistCircumference",66.04);
        contentValues.put("rfm",38.06);
        contentValues.put("pushUpScore",10);
        contentValues.put("sitUpScore",12);
        contentValues.put("frequencyOfExercise",1);
        try {
            workoutUserManager.addWorkoutUserRow(contentValues);
        }
        catch(Exception exception)
        {
            Log.i("Error: ",exception.getMessage());
        }
    }
}
