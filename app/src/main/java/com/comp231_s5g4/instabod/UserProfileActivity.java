package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserProfileActivity extends AppCompatActivity {

    EditText editHeightTextView,editWaistText,editPushupText,situpEditText,frequencyEditText;
    Button submitButton;

    WorkoutUserManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        db= new WorkoutUserManager(getApplicationContext());

        editHeightTextView= findViewById(R.id.editHeightText);
        editWaistText = findViewById(R.id.editWaistText);
        editPushupText = findViewById(R.id.editPushupText);
        situpEditText = findViewById(R.id.situpEditText);
        frequencyEditText = findViewById(R.id.frequencyEditText);

        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int height=0,waist=0,pushScore=0,situpScore=0,frequency=0;

                editHeightTextView.setTextColor(Color.BLACK);
                editWaistText.setTextColor(Color.BLACK);
                editPushupText.setTextColor(Color.BLACK);
                situpEditText.setTextColor(Color.BLACK);
                frequencyEditText.setTextColor(Color.BLACK);

                Boolean isFocused=false;
                Boolean isError=true;

                if(!editHeightTextView.getText().toString().equals("")){
                    height = Integer.parseInt(editHeightTextView.getText().toString());
                }
                else{
                    editHeightTextView.requestFocus();
                    isError=false;
                }
                if(!editWaistText.getText().toString().equals("")){
                    waist = Integer.parseInt(editWaistText.getText().toString());
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


                if(height > 250){
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
                if(waist > 200){
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

                    /*

                    DB Code Goes Here and will be done after the registration part is done
                    because of dependency.

                     */
                }
            }
        });


    }
}