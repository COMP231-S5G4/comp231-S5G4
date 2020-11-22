package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        try{
            height = Integer.parseInt(heightEditText.getText().toString());
            waist = Integer.parseInt(waistEditText.getText().toString());
            pushUps = Integer.parseInt(pushUpScoreEditText.getText().toString());
            sitUpScore = Integer.parseInt(situpScoreEditText.getText().toString());
            freqExercise = Integer.parseInt(freqExerciseEditText.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(this, "Invalid input(s)", Toast.LENGTH_SHORT).show();
            return;
        }
        if(height == 0){
            Toast.makeText(this, "Invalid input(s)", Toast.LENGTH_SHORT).show();
            return;
        }
        if(waist == 0){
            Toast.makeText(this, "Invalid input(s)", Toast.LENGTH_SHORT).show();
            return;
        }
        if(pushUps == 0){
            Toast.makeText(this, "Invalid input(s)", Toast.LENGTH_SHORT).show();
            return;
        }
        if(sitUpScore == 0){
            Toast.makeText(this, "Invalid input(s)", Toast.LENGTH_SHORT).show();
            return;
        }
        if(freqExercise == 0){
            Toast.makeText(this, "Invalid input(s)", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(intent);
    }
}