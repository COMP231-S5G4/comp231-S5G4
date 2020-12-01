package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ModifyUserProfileActivity extends AppCompatActivity {

    private EditText heightEditText, waistEditText, pushUpScoreEditText,sitUpScoreEditText,freqExerciseEditText;
    private int userID;
    private String gender;
    private WorkoutUserManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user_profile);
        heightEditText = findViewById(R.id.editHeightText);
        waistEditText = findViewById(R.id.editWaistText);
        pushUpScoreEditText = findViewById(R.id.editPushupText);
        sitUpScoreEditText = findViewById(R.id.situpEditText);
        freqExerciseEditText = findViewById(R.id.frequencyEditText);

        SharedPreferences sharedPreferences =  getSharedPreferences("WorkoutUserSharedPreferences", MODE_PRIVATE);
        userID = sharedPreferences.getInt("userId",-1);
        try {
            db = new WorkoutUserManager(this);
            WorkoutUser workoutUser = db.getWorkoutUserById(userID, "username");

            heightEditText.setText(Double.toString(workoutUser.getHeight()));
            waistEditText.setText(Double.toString(workoutUser.getWaistCircumference()));
            pushUpScoreEditText.setText(Integer.toString(workoutUser.getPushUpScore()));
            sitUpScoreEditText.setText(Integer.toString(workoutUser.getSitUpScore()));
            freqExerciseEditText.setText(Integer.toString(workoutUser.getFrequencyOfExercise()));
            gender = workoutUser.getGender();
        }
        catch (Exception exception)
        {
            Toast.makeText(this,
                    exception.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("Error: ",exception.getMessage());
        }
    }
    public void modifyUserProfile(View v) throws Exception {
        double height=0,waist=0;
        int frequency=0,pushScore=0,situpScore=0;

        heightEditText.setTextColor(Color.BLACK);
        waistEditText.setTextColor(Color.BLACK);
        pushUpScoreEditText.setTextColor(Color.BLACK);
        sitUpScoreEditText.setTextColor(Color.BLACK);
        freqExerciseEditText.setTextColor(Color.BLACK);

        Boolean isFocused=false;
        Boolean isError=true;

        if(!heightEditText.getText().toString().equals("")){
            height = Double.parseDouble(heightEditText.getText().toString());
        }
        else{
            heightEditText.requestFocus();
            isError=false;
        }
        if(!waistEditText.getText().toString().equals("")){
            waist = Double.parseDouble(waistEditText.getText().toString());
        }
        else{
            waistEditText.requestFocus();
            isError=false;
        }
        if(!pushUpScoreEditText.getText().toString().equals("")){
            pushScore = Integer.parseInt(pushUpScoreEditText.getText().toString());
        }
        else{
            pushUpScoreEditText.requestFocus();
            isError=false;
        }
        if(!sitUpScoreEditText.getText().toString().equals("")){
            situpScore= Integer.parseInt(sitUpScoreEditText.getText().toString());
        }
        else{
            sitUpScoreEditText.requestFocus();
            isError=false;
        }
        if(!freqExerciseEditText.getText().toString().equals("")){
            frequency =Integer.parseInt(freqExerciseEditText.getText().toString());
        }
        else{
            freqExerciseEditText.requestFocus();
            isError=false;
        }


        if(height > 250.0d){
            heightEditText.setTextColor(Color.RED);
            if(!isFocused){
                heightEditText.requestFocus();
            }
            isError=false;
            isFocused=true;
        }
        else
        {
            isFocused=false;
        }
        if(waist > 200.0d){
            waistEditText.setTextColor(Color.RED);
            if(!isFocused){
                waistEditText.requestFocus();
            }
            isError=false;
            isFocused=true;

        }
        else
        {
            isFocused=false;
        }
        if(pushScore > 150){
            pushUpScoreEditText.setTextColor(Color.RED);
            if(!isFocused){
                pushUpScoreEditText.requestFocus();
            }
            isError=false;
            isFocused=true;

        }
        else
        {
            isFocused=false;
        }
        if(situpScore > 100){
            sitUpScoreEditText.setTextColor(Color.RED);
            if(!isFocused){
                sitUpScoreEditText.requestFocus();
            }
            isError=false;
            isFocused=true;

        }
        else
        {
            isFocused=false;
        }
        if(frequency > 7){
            freqExerciseEditText.setTextColor(Color.RED);
            if(!isFocused){
                freqExerciseEditText.requestFocus();
            }
            isError=false;
            isFocused=true;
        }
        else
        {
            isFocused=false;
        }

        if(isError){
            WorkoutUser workoutUser=new WorkoutUser();
            workoutUser.setHeight(height);
            workoutUser.setWaistCircumference(waist);
            workoutUser.setPushUpScore(pushScore);
            workoutUser.setSitUpScore(situpScore);
            workoutUser.setFrequencyOfExercise(frequency);

            double temp=height/waist;

            double rfm;
            rfm = 64 - (20 * temp);


            SharedPreferences sharedPreferences =  getSharedPreferences("WorkoutUserSharedPreferences", MODE_PRIVATE);
            userID = sharedPreferences.getInt("userId",-1);

            if(gender.equals("Male")){
                rfm = 64 - (20 * temp);
            }
            else{
                rfm = 76 - (20 * temp);
            }

            DecimalFormat df = new DecimalFormat("#.00");
            double formattedRFM = Double.parseDouble(df.format(rfm));
            workoutUser.setRfm(formattedRFM);

            ContentValues cv = new ContentValues();
            cv.put("height",workoutUser.getHeight());
            cv.put("waistCircumference",workoutUser.getWaistCircumference());
            cv.put("rfm",workoutUser.getRfm());
            cv.put("pushUpScore",workoutUser.getPushUpScore());
            cv.put("sitUpScore",workoutUser.getSitUpScore());
            cv.put("frequencyOfExercise",workoutUser.getFrequencyOfExercise());

            boolean result = false;
            try {
                result = db.updateWorkoutUserRow(userID, "username", cv);
            } catch (Exception e) {
                e.printStackTrace();
                result = false;
            }

            if(result){
                startActivity(new Intent(getApplicationContext(),WorkoutPlanActivity.class));
            }

        }
    }
}