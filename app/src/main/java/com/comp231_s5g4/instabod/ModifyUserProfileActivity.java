package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyUserProfileActivity extends AppCompatActivity {

    private WorkoutUserManager workoutuserManager;

    private EditText heightEditText, waistEditText, pushUpScoreEditText,situpScoreEditText,freqExerciseEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user_profile);
        heightEditText = (EditText) findViewById(R.id.editHeightText);
        waistEditText = (EditText) findViewById(R.id.editWaistText);
        pushUpScoreEditText = (EditText) findViewById(R.id.editPushupText);
        situpScoreEditText = (EditText) findViewById(R.id.situpEditText);
        freqExerciseEditText = (EditText) findViewById(R.id.frequencyEditText);

        /*Populating the fields with the User Data
           - Uncomment this logic when the User Registration is done in the Iteration2
        */
//        try {
//            WorkoutUser workoutUser = workoutuserManager.getWorkoutUserById(WorkoutUser.convertUsernameToUniqueId(null), "WorkoutUserId");
//            heightEditText.setText((int) workoutUser.getHeight());
//            waistEditText.setText((int)workoutUser.getWaistCircumference());
//            pushUpScoreEditText.setText( workoutUser.getPushUpScore());
//            situpScoreEditText.setText( workoutUser.getSitUpScore());
//            freqExerciseEditText.setText( workoutUser.getFrequencyOfExercise());
//        }
//        catch (Exception exception)
//        {
//            Toast.makeText(ModifyUserProfileActivity.this,
//                    exception.getMessage(), Toast.LENGTH_SHORT).show();
//            Log.i("Error: ",exception.getMessage());
//        }
    }
}
    public void modifyUserProfile(View v){
        Intent intent = new Intent(this, WorkoutPlanActivity.class);
        heightEditText = findViewById(R.id.editHeightText);
        waistEditText = findViewById(R.id.editWaistText);
        pushUpScoreEditText = findViewById(R.id.editWaistText);
        situpScoreEditText = findViewById(R.id.situpEditText);
        freqExerciseEditText = findViewById(R.id.frequencyEditText);
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
      
      //Code Pushing the Updated text field data will go here after the registration part is done in iteration 2
    }
}