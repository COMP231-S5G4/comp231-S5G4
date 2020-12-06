package com.comp231_s5g4.instabod;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

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

    WorkoutUserManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plan);
        setTitle("Home");

        day1 = new Workout[3];
        day2 = new Workout[3];
        day3 = new Workout[3];
        day4 = new Workout[3];
        day5 = new Workout[3];
        day6 = new Workout[3];
        day7 = new Workout[3];

        db= new WorkoutUserManager(getApplicationContext());

        SharedPreferences sharedPreferences = getSharedPreferences("WorkoutUserSharedPreferences",MODE_PRIVATE);
        int userId = sharedPreferences.getInt("id",-1);
        int tempGender = 1;
        WorkoutUser workoutUser = new WorkoutUser();

        try {
            workoutUser = db.getWorkoutUserById(userId,"username");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(workoutUser.getGender().equals("Male")){
            tempGender = 1;
        }
        else{
            tempGender = 0;
        }

        hideDayButton(workoutUser);

        //Toast.makeText(getApplicationContext(),"User Id:"+userId,Toast.LENGTH_LONG).show();

        WorkoutAlgorithm workoutAlgorithm = new WorkoutAlgorithm(workoutUser.getRfm(),workoutUser.getAge(),tempGender);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_layout_1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.optionOneProfile:
                userProfile();
                break;
            case R.id.optionOneLogout:
                logout();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void hideDayButton(WorkoutUser workoutUser){
        Button day1Button,day2Button,day3Button,day4Button,day5Button,day6Button,day7Button;
        day1Button = findViewById(R.id.day1_button);
        day2Button = findViewById(R.id.day2_button);
        day3Button = findViewById(R.id.day3_button);
        day4Button = findViewById(R.id.day4_button);
        day5Button = findViewById(R.id.day5_button);
        day6Button = findViewById(R.id.day6_button);
        day7Button = findViewById(R.id.day7_button);

        if(workoutUser.getFrequencyOfExercise() == 1){
            day2Button.setVisibility(View.GONE);
            day3Button.setVisibility(View.GONE);
            day4Button.setVisibility(View.GONE);
            day5Button.setVisibility(View.GONE);
            day6Button.setVisibility(View.GONE);
            day7Button.setVisibility(View.GONE);
        }
        else if(workoutUser.getFrequencyOfExercise() == 2){
            day3Button.setVisibility(View.GONE);
            day4Button.setVisibility(View.GONE);
            day5Button.setVisibility(View.GONE);
            day6Button.setVisibility(View.GONE);
            day7Button.setVisibility(View.GONE);
        }
        else if(workoutUser.getFrequencyOfExercise() == 3){
            day4Button.setVisibility(View.GONE);
            day5Button.setVisibility(View.GONE);
            day6Button.setVisibility(View.GONE);
            day7Button.setVisibility(View.GONE);
        }
        else if(workoutUser.getFrequencyOfExercise() == 4){
            day5Button.setVisibility(View.GONE);
            day6Button.setVisibility(View.GONE);
            day7Button.setVisibility(View.GONE);
        }
        else if(workoutUser.getFrequencyOfExercise() == 5){
            day6Button.setVisibility(View.GONE);
            day7Button.setVisibility(View.GONE);
        }
        else if(workoutUser.getFrequencyOfExercise() == 6){
            day7Button.setVisibility(View.GONE);
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
    public void userProfile(){
        Intent intent = new Intent(this, ModifyUserProfileActivity.class);
        startActivity(intent);
    }
    public void logout(){
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