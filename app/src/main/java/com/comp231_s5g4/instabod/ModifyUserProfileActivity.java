package com.comp231_s5g4.instabod;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ModifyUserProfileActivity extends AppCompatActivity {

    private EditText heightEditText, waistEditText, pushUpScoreEditText,sitUpScoreEditText,freqExerciseEditText;
    private int userID;
    private String gender;
    private WorkoutUserManager db;
    YouTubePlayer playerRef;
    YouTubePlayerFragment youtubeFragment;
    private TextView tutorialOne,tutorialTwo;
    boolean isVideoLoaded = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user_profile);
        youtubeFragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtubePlayerFragment);
        youtubeFragment.initialize(YoutubeConfig.API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                playerRef = youTubePlayer;
                isVideoLoaded = true;
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                isVideoLoaded = false;
            }
        });

        setTitle("Profile");
        heightEditText = findViewById(R.id.searchEditText);
        waistEditText = findViewById(R.id.editWaistText);
        pushUpScoreEditText = findViewById(R.id.editPushupText);
        sitUpScoreEditText = findViewById(R.id.situpEditText);
        freqExerciseEditText = findViewById(R.id.frequencyEditText);
        tutorialOne = findViewById(R.id.tutorialTextView);
        tutorialTwo = findViewById(R.id.tutorial2TextView);

        tutorialOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isVideoLoaded) {
                    playerRef.loadVideo("IODxDxX7oi4");
                }
                else {
                    Toast.makeText(getApplicationContext(),"Failed to connect to YouTube Service",Toast.LENGTH_LONG).show();
                }
            }
        });
        tutorialTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isVideoLoaded) {
                    playerRef.loadVideo("1fbU_MkV7NE");
                }
                else {
                    Toast.makeText(getApplicationContext(),"Failed to connect to YouTube Service",Toast.LENGTH_LONG).show();
                }
            }
        });

        SharedPreferences sharedPreferences =  getSharedPreferences("WorkoutUserSharedPreferences", MODE_PRIVATE);
        userID = sharedPreferences.getInt("id",-1);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_layout_2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.optionTwoProfile:
                home();
                break;
            case R.id.optionTwoLogout:
                logout();
                break;
        }

        return super.onOptionsItemSelected(item);
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
            //Toast.makeText(getApplicationContext(),"Freq:"+frequency,Toast.LENGTH_LONG).show();
            workoutUser.setFrequencyOfExercise(frequency);

            double temp=height/waist;



            double rfm;


            SharedPreferences sharedPreferences =  getSharedPreferences("WorkoutUserSharedPreferences", MODE_PRIVATE);
            userID = sharedPreferences.getInt("id",-1);

            if(gender.equals("Male")){
                rfm = 64.0d - (20.0d * temp);
            }
            else{
                rfm = 76.0d - (20 * temp);
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
    public void home(){
        Intent intent = new Intent(this, WorkoutPlanActivity.class);
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