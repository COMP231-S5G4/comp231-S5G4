package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class UserProfileActivity extends AppCompatActivity {

    EditText editHeightTextView,editWaistText,editPushupText,situpEditText,frequencyEditText;
    Button submitButton;

    WorkoutUserManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        setTitle("Profile");
        db= new WorkoutUserManager(getApplicationContext());

        editHeightTextView= findViewById(R.id.searchEditText);
        editWaistText = findViewById(R.id.editWaistText);
        editPushupText = findViewById(R.id.editPushupText);
        situpEditText = findViewById(R.id.situpEditText);
        frequencyEditText = findViewById(R.id.frequencyEditText);

        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height=0,waist=0;
                int frequency=0,pushScore=0,situpScore=0;

                editHeightTextView.setTextColor(Color.BLACK);
                editWaistText.setTextColor(Color.BLACK);
                editPushupText.setTextColor(Color.BLACK);
                situpEditText.setTextColor(Color.BLACK);
                frequencyEditText.setTextColor(Color.BLACK);

                Boolean isFocused=false;
                Boolean isError=true;

                if(!editHeightTextView.getText().toString().equals("")){
                    height = Double.parseDouble(editHeightTextView.getText().toString());
                }
                else{
                    editHeightTextView.requestFocus();
                    isError=false;
                }
                if(!editWaistText.getText().toString().equals("")){
                    waist = Double.parseDouble(editWaistText.getText().toString());
                }
                else{
                    editWaistText.requestFocus();
                    isError=false;
                }
                if(!editPushupText.getText().toString().equals("")){
                    pushScore = Integer.parseInt(editPushupText.getText().toString());
                }
                else{
                    editPushupText.requestFocus();
                    isError=false;
                }
                if(!situpEditText.getText().toString().equals("")){
                    situpScore= Integer.parseInt(situpEditText.getText().toString());
                }
                else{
                    situpEditText.requestFocus();
                    isError=false;
                }
                if(!frequencyEditText.getText().toString().equals("")){
                    frequency =Integer.parseInt(frequencyEditText.getText().toString());
                }
                else{
                    frequencyEditText.requestFocus();
                    isError=false;
                }


                if(height > 250.0d){
                    editHeightTextView.setTextColor(Color.RED);
                    if(!isFocused){
                        editHeightTextView.requestFocus();
                    }
                    isError=false;
                    isFocused=true;
                }
                else
                {
                    isFocused=false;
                }
                if(waist > 200.0d){
                    editWaistText.setTextColor(Color.RED);
                    if(!isFocused){
                        editWaistText.requestFocus();
                    }
                    isError=false;
                    isFocused=true;

                }
                else
                {
                    isFocused=false;
                }
                if(pushScore > 150){
                    editPushupText.setTextColor(Color.RED);
                    if(!isFocused){
                        editPushupText.requestFocus();
                    }
                    isError=false;
                    isFocused=true;

                }
                else
                {
                    isFocused=false;
                }
                if(situpScore > 100){
                    situpEditText.setTextColor(Color.RED);
                    if(!isFocused){
                        situpEditText.requestFocus();
                    }
                    isError=false;
                    isFocused=true;

                }
                else
                {
                    isFocused=false;
                }
                if(frequency > 7){
                    frequencyEditText.setTextColor(Color.RED);
                    if(!isFocused){
                        frequencyEditText.requestFocus();
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
                    int userId = sharedPreferences.getInt("id",-1);
                    String username = sharedPreferences.getString("username",null);
                    String password = sharedPreferences.getString("password",null);
                    int age = sharedPreferences.getInt("age",-1);
                    String gender = sharedPreferences.getString("gender",null);
                    String secQuesFirst = sharedPreferences.getString("securityFirstQuestion",null);
                    String secQuesSec = sharedPreferences.getString("securitySecondQuestion",null);
                    String secAnsFirst = sharedPreferences.getString("securityFirstAnswer",null);
                    String secAnsSec = sharedPreferences.getString("securitySecondAnswer",null);

                    workoutUser.setUserName(userId);
                    workoutUser.setPassword(password);
                    workoutUser.setAge(age);
                    workoutUser.setGender(gender);
                    workoutUser.setSecurityQ1(secQuesFirst);
                    workoutUser.setSecurityQ2(secQuesSec);
                    workoutUser.setSecurityA1(secAnsFirst);
                    workoutUser.setSecurityA2(secAnsSec);

                    if(gender.equals("Male")){
                        rfm = 64 - (20 * temp);
                    }
                    else{
                        rfm = 76 - (20 * temp);
                    }

                    DecimalFormat df = new DecimalFormat("#.00");
                    double formattedRFM = Double.parseDouble(df.format(rfm));
                    workoutUser.setRfm(formattedRFM);

                    //Toast.makeText(getApplicationContext(),"Formatted RFM:"+formattedRFM,Toast.LENGTH_LONG).show();

                    ContentValues cv = new ContentValues();
                    cv.put("username",workoutUser.getUserName());
                    cv.put("password",workoutUser.getPassword());
                    cv.put("age",workoutUser.getAge());
                    cv.put("gender",workoutUser.getGender());
                    cv.put("securityQuestion1",workoutUser.getSecurityQ1());
                    cv.put("securityAnswer1",workoutUser.getSecurityA1());
                    cv.put("securityQuestion2",workoutUser.getSecurityQ2());
                    cv.put("securityAnswer2",workoutUser.getSecurityA2());
                    cv.put("height",workoutUser.getHeight());
                    cv.put("waistCircumference",workoutUser.getWaistCircumference());
                    cv.put("rfm",workoutUser.getRfm());
                    cv.put("pushUpScore",workoutUser.getPushUpScore());
                    cv.put("sitUpScore",workoutUser.getSitUpScore());
                    cv.put("frequencyOfExercise",workoutUser.getFrequencyOfExercise());

                    boolean result = false;
                    try {
                        result = db.addWorkoutUserRow(cv);
                    } catch (Exception e) {
                        e.printStackTrace();
                        result = false;
                    }

                    if(result){
                        startActivity(new Intent(getApplicationContext(),WorkoutPlanActivity.class));
                    }

                }
            }
        });


    }
}