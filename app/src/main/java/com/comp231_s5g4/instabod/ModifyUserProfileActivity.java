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
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ModifyUserProfileActivity extends AppCompatActivity {

    private EditText heightEditText, waistEditText, pushUpScoreEditText,sitUpScoreEditText,freqExerciseEditText;
    private int userID;
    private String gender;
    private WorkoutUserManager db;

    private YouTubePlayerFragment youTubePlayerFragment;
    //youtube player to play video when new video selected
    private YouTubePlayer youTubePlayer;
    private ArrayList<String> videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user_profile);
        setTitle("Profile");
        heightEditText = findViewById(R.id.searchEditText);
        waistEditText = findViewById(R.id.editWaistText);
        pushUpScoreEditText = findViewById(R.id.editPushupText);
        sitUpScoreEditText = findViewById(R.id.situpEditText);
        freqExerciseEditText = findViewById(R.id.frequencyEditText);

        // Below are the random videos for testing purposes
        // put the appropriate ones when the youtube fragment works
        videoList=new ArrayList<String>();
        videoList.add("CqhpNxI8qYw");
        videoList.add("sasCrpgHDy8");

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
            rfm = 64 - (20 * temp);


            SharedPreferences sharedPreferences =  getSharedPreferences("WorkoutUserSharedPreferences", MODE_PRIVATE);
            userID = sharedPreferences.getInt("id",-1);

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

    public void firstTutorial(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Perform the Push Ups as shown in the video until you get exhausted and record your score").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (youTubePlayerFragment != null && youTubePlayer != null) {
                    initializeYoutubePlayer(0);
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void secondTutorial(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Perform the Sit Ups as shown in the video for 1 minute and record your score").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (youTubePlayerFragment != null && youTubePlayer != null) {
                    initializeYoutubePlayer(1);
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    /**
     * initialize youtube player via Fragment and get instance of YoutubePlayer
     */
    private void initializeYoutubePlayer(final int videoId) {
        youTubePlayerFragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_player_fragment);
        if (youTubePlayerFragment == null)
            return;
        youTubePlayerFragment.initialize("AIzaSyBOF47UsXb1aPW1Z5cCI52lD8o35-Z83v8", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                                boolean wasRestored) {
                if (!wasRestored) {
                    youTubePlayer = player;
                    //set the player style default
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
                    //Cue the specific video based on the button
                    youTubePlayer.cueVideo(videoList.get(videoId));
                }
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
                //print or show error if initialization failed
                Toast.makeText(getApplicationContext(), "Youtube Player View initialization failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}