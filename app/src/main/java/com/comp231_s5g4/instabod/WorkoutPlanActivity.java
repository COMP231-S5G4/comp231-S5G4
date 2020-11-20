package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class WorkoutPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plan);

    }


    public void day1Button(View view)
    {
        Intent intent = new Intent(WorkoutPlanActivity.this,PopUpActivity.class);
        intent.putExtra("dayTitle","DAY1 EXERCISE");
        startActivity(intent);
    }

    public void day2Button(View view)
    {
        Intent intent = new Intent(WorkoutPlanActivity.this,PopUpActivity.class);
        intent.putExtra("dayTitle","DAY2 EXERCISE");
        startActivity(intent);
    }

    public void day3Button(View view)
    {
        Intent intent = new Intent(WorkoutPlanActivity.this,PopUpActivity.class);
        intent.putExtra("dayTitle","DAY3 EXERCISE");
        startActivity(intent);
    }

    public void day4Button(View view)
    {
        Intent intent = new Intent(WorkoutPlanActivity.this,PopUpActivity.class);
        intent.putExtra("dayTitle","DAY4 EXERCISE");
        startActivity(intent);
    }

    public void day5Button(View view)
    {
        Intent intent = new Intent(WorkoutPlanActivity.this,PopUpActivity.class);
        intent.putExtra("dayTitle","DAY5 EXERCISE");
        startActivity(intent);
    }

    public void day6Button(View view)
    {
        Intent intent = new Intent(WorkoutPlanActivity.this,PopUpActivity.class);
        intent.putExtra("dayTitle","DAY6 EXERCISE");
        startActivity(intent);
    }

    public void day7Button(View view)
    {
        Intent intent = new Intent(WorkoutPlanActivity.this,PopUpActivity.class);
        intent.putExtra("dayTitle","DAY7 EXERCISE");
        startActivity(intent);
    }



}