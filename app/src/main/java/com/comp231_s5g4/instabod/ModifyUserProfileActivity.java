package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyUserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user_profile);
    }

    public void onButtonClick(View v){
        Intent intent = new Intent(this, WorkoutPlanActivity.class);
        EditText heightEditText = findViewById(R.id.editHeightText);
        EditText waistEditText = findViewById(R.id.editWaistText);
        EditText pushUpScoreEditText = findViewById(R.id.editWaistText);
        EditText situpScoreEditText = findViewById(R.id.situpEditText);
        EditText freqExerciseEditText = findViewById(R.id.frequencyEditText);
        int height = 0;
        int waist = 0;
        int pushUps = 0;
        int sitUpScore = 0;
        int freqExercise = 0;
        Boolean isFocused = false;



        try{
            height = Integer.parseInt(heightEditText.getText().toString());
        }
        catch (Exception e){
            heightEditText.requestFocus();
            heightEditText.setTextColor(Color.RED);
            return;
        }

        try{
            waist = Integer.parseInt(waistEditText.getText().toString());
        }
        catch(Exception e){
            waistEditText.requestFocus();
            waistEditText.setTextColor(Color.RED);
            return;
        }
        try{
            pushUps = Integer.parseInt(pushUpScoreEditText.getText().toString());
        }
        catch (Exception e){
            pushUpScoreEditText.requestFocus();
            heightEditText.setTextColor(Color.RED);
            return;
        }
        try{
            sitUpScore = Integer.parseInt(situpScoreEditText.getText().toString());
        }
        catch (Exception e){
            situpScoreEditText.requestFocus();
            heightEditText.setTextColor(Color.RED);
            return;
        }
        try{
            freqExercise = Integer.parseInt(freqExerciseEditText.getText().toString());
        }
        catch(Exception e){
            freqExerciseEditText.requestFocus();
            freqExerciseEditText.setTextColor(Color.RED);
            return;
        }





        if(height == 0 || height > 250){
            heightEditText.setTextColor(Color.RED);
            if(!isFocused){
                heightEditText.requestFocus();
                isFocused = true;
            }
            return;
        }
        if(waist == 0 || waist > 200){
            waistEditText.setTextColor(Color.RED);
            if(!isFocused){
                waistEditText.requestFocus();
                isFocused = true;
            }
            return;
        }
        if(pushUps == 0 || pushUps > 150){
            pushUpScoreEditText.setTextColor(Color.RED);
            if(!isFocused){
                pushUpScoreEditText.requestFocus();
                isFocused = true;
            }
            return;
        }
        if(sitUpScore == 0 || sitUpScore > 100){
            situpScoreEditText.setTextColor(Color.RED);
            if(!isFocused){
                situpScoreEditText.requestFocus();
                isFocused = true;
            }
            return;
        }
        if(freqExercise == 0 || freqExercise > 7){
            freqExerciseEditText.setTextColor(Color.RED);
            if(!isFocused){
                freqExerciseEditText.requestFocus();
                isFocused = true;
            }
            return;
        }
        startActivity(intent);
    }
}