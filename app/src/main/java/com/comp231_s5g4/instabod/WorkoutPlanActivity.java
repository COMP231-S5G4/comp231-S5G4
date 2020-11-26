package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class WorkoutPlanActivity extends AppCompatActivity {
    ArrayList<Workout> workouts;
    Workout[] day1;
    Workout[] day2;
    Workout[] day3;
    Workout[] day4;
    Workout[] day5;
    Workout[] day6;
    Workout[] day7;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plan);
        day1 = new Workout[3];
        day2 = new Workout[3];
        day3 = new Workout[3];
        day4 = new Workout[3];
        day5 = new Workout[3];
        day6 = new Workout[3];
        day7 = new Workout[3];
        WorkoutAlgorithm workoutAlgorithm = new WorkoutAlgorithm();
        workouts = workoutAlgorithm.generateWorkout();
        //day1
        int pos = 0;
        for(int i = 0; i < 3; i++){
            day1[i] = workouts.get(pos);
            if(pos >= workouts.size())
            {
                pos = 0;
            }
            else{
                pos++;
            }
        }
        //day2
        for(int i = 0; i < 3; i++){
            if(pos >= workouts.size())
            {
                pos = 0;
            }
            day2[i] = workouts.get(pos);
            pos++;
        }
        //day3
        for(int i = 0; i < 3; i++){
            if(pos >= workouts.size())
            {
                pos = 0;
            }
            day3[i] = workouts.get(pos);
            pos++;
        }
        //day4
        for(int i = 0; i < 3; i++){
            if(pos >= workouts.size())
            {
                pos = 0;
            }
            day4[i] = workouts.get(pos);
            pos++;
        }
        //day5
        for(int i = 0; i < 3; i++){
            if(pos >= workouts.size())
            {
                pos = 0;
            }
            day5[i] = workouts.get(pos);
            pos++;
        }
        //day6
        for(int i = 0; i < 3; i++){
            if(pos >= workouts.size())
            {
                pos = 0;
            }
            day6[i] = workouts.get(pos);
            pos++;
        }
        //day7
        for(int i = 0; i < 3; i++){
            if(pos >= workouts.size())
            {
                pos = 0;
            }
            day7[i] = workouts.get(pos);
            pos++;
        }
    }


    public void day1Button(View view)
    {
        Workout workout1 = day1[0];
        Workout workout2 = day1[1];
        Workout workout3 = day1[2];
        Intent intent = new Intent(this, PopUpActivity.class);
        //workout1
        intent.putExtra("dayTitle","DAY1 EXERCISE");
        intent.putExtra("workout1Name", workout1.getWorkoutName());
        intent.putExtra( "workout1Reps", workout1.getRepetition());
        intent.putExtra("workout1HyperLink", workout1.getVideoHyperlink());
        //workout2
        intent.putExtra("workout2Name", workout2.getWorkoutName());
        intent.putExtra( "workout2Reps", workout2.getRepetition());
        intent.putExtra("workout2HyperLink", workout2.getVideoHyperlink());
        //workout3
        intent.putExtra("workout3Name", workout3.getWorkoutName());
        intent.putExtra( "workout3Reps", workout3.getRepetition());
        intent.putExtra("workout3HyperLink", workout3.getVideoHyperlink());
        startActivity(intent);
    }

    public void day2Button(View view)
    {
        Workout workout1 = day2[0];
        Workout workout2 = day2[1];
        Workout workout3 = day2[2];
        Intent intent = new Intent(this,PopUpActivity.class);
        intent.putExtra("dayTitle","DAY2 EXERCISE");
        //workout1
        intent.putExtra("workout1Name", workout1.getWorkoutName());
        intent.putExtra( "workout1Reps", workout1.getRepetition());
        intent.putExtra("workout1HyperLink", workout1.getVideoHyperlink());
        //workout2
        intent.putExtra("workout2Name", workout2.getWorkoutName());
        intent.putExtra( "workout2Reps", workout2.getRepetition());
        intent.putExtra("workout2HyperLink", workout2.getVideoHyperlink());
        //workout3
        intent.putExtra("workout3Name", workout3.getWorkoutName());
        intent.putExtra( "workout3Reps", workout3.getRepetition());
        intent.putExtra("workout3HyperLink", workout3.getVideoHyperlink());
        startActivity(intent);
    }

    public void day3Button(View view)
    {
        Workout workout1 = day3[0];
        Workout workout2 = day3[1];
        Workout workout3 = day3[2];
        Intent intent = new Intent(this,PopUpActivity.class);
        intent.putExtra("dayTitle","DAY3 EXERCISE");
        //workout1
        intent.putExtra("workout1Name", workout1.getWorkoutName());
        intent.putExtra( "workout1Reps", workout1.getRepetition());
        intent.putExtra("workout1HyperLink", workout1.getVideoHyperlink());
        //workout2
        intent.putExtra("workout2Name", workout2.getWorkoutName());
        intent.putExtra( "workout2Reps", workout2.getRepetition());
        intent.putExtra("workout2HyperLink", workout2.getVideoHyperlink());
        //workout3
        intent.putExtra("workout3Name", workout3.getWorkoutName());
        intent.putExtra( "workout3Reps", workout3.getRepetition());
        intent.putExtra("workout3HyperLink", workout3.getVideoHyperlink());
        startActivity(intent);
    }

    public void day4Button(View view)
    {
        Workout workout1 = day4[0];
        Workout workout2 = day4[1];
        Workout workout3 = day4[2];
        Intent intent = new Intent(this,PopUpActivity.class);
        intent.putExtra("dayTitle","DAY4 EXERCISE");
        //workout1
        intent.putExtra("workout1Name", workout1.getWorkoutName());
        intent.putExtra( "workout1Reps", workout1.getRepetition());
        intent.putExtra("workout1HyperLink", workout1.getVideoHyperlink());
        //workout2
        intent.putExtra("workout2Name", workout2.getWorkoutName());
        intent.putExtra( "workout2Reps", workout2.getRepetition());
        intent.putExtra("workout2HyperLink", workout2.getVideoHyperlink());
        //workout3
        intent.putExtra("workout3Name", workout3.getWorkoutName());
        intent.putExtra( "workout3Reps", workout3.getRepetition());
        intent.putExtra("workout3HyperLink", workout3.getVideoHyperlink());
        startActivity(intent);
    }

    public void day5Button(View view)
    {
        Workout workout1 = day5[0];
        Workout workout2 = day5[1];
        Workout workout3 = day5[2];
        Intent intent = new Intent(this,PopUpActivity.class);
        intent.putExtra("dayTitle","DAY5 EXERCISE");
        //workout1
        intent.putExtra("workout1Name", workout1.getWorkoutName());
        intent.putExtra( "workout1Reps", workout1.getRepetition());
        intent.putExtra("workout1HyperLink", workout1.getVideoHyperlink());
        //workout2
        intent.putExtra("workout2Name", workout2.getWorkoutName());
        intent.putExtra( "workout2Reps", workout2.getRepetition());
        intent.putExtra("workout2HyperLink", workout2.getVideoHyperlink());
        //workout3
        intent.putExtra("workout3Name", workout3.getWorkoutName());
        intent.putExtra( "workout3Reps", workout3.getRepetition());
        intent.putExtra("workout3HyperLink", workout3.getVideoHyperlink());
        startActivity(intent);
    }

    public void day6Button(View view)
    {
        Workout workout1 = day6[0];
        Workout workout2 = day6[1];
        Workout workout3 = day6[2];
        Intent intent = new Intent(this,PopUpActivity.class);
        intent.putExtra("dayTitle","DAY6 EXERCISE");
        //workout1
        intent.putExtra("workout1Name", workout1.getWorkoutName());
        intent.putExtra( "workout1Reps", workout1.getRepetition());
        intent.putExtra("workout1HyperLink", workout1.getVideoHyperlink());
        //workout2
        intent.putExtra("workout2Name", workout2.getWorkoutName());
        intent.putExtra( "workout2Reps", workout2.getRepetition());
        intent.putExtra("workout2HyperLink", workout2.getVideoHyperlink());
        //workout3
        intent.putExtra("workout3Name", workout3.getWorkoutName());
        intent.putExtra( "workout3Reps", workout3.getRepetition());
        intent.putExtra("workout3HyperLink", workout3.getVideoHyperlink());
        startActivity(intent);
    }

    public void day7Button(View view)
    {
        Workout workout1 = day7[0];
        Workout workout2 = day7[1];
        Workout workout3 = day7[2];
        Intent intent = new Intent(this,PopUpActivity.class);
        intent.putExtra("dayTitle","DAY7 EXERCISE");
        //workout1
        intent.putExtra("workout1Name", workout1.getWorkoutName());
        intent.putExtra( "workout1Reps", workout1.getRepetition());
        intent.putExtra("workout1HyperLink", workout1.getVideoHyperlink());
        //workout2
        intent.putExtra("workout2Name", workout2.getWorkoutName());
        intent.putExtra( "workout2Reps", workout2.getRepetition());
        intent.putExtra("workout2HyperLink", workout2.getVideoHyperlink());
        //workout3
        intent.putExtra("workout3Name", workout3.getWorkoutName());
        intent.putExtra( "workout3Reps", workout3.getRepetition());
        intent.putExtra("workout3HyperLink", workout3.getVideoHyperlink());
        startActivity(intent);
    }

    public void logout(View v){
        SharedPreferences sharedPreferences = getSharedPreferences("WorkoutUserSharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("username");
        editor.remove("password");
        editor.remove("id");
        editor.apply();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}