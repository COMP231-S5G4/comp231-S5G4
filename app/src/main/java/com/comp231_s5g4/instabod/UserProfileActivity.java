package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class UserProfileActivity extends AppCompatActivity {

    EditText editHeightTextView,editWaistText,editPushupText,situpEditText,frequencyEditText;
    Button submitButton;

    WorkoutUserManager db;

    private YouTubePlayerFragment youTubePlayerFragment;
    //youtube player to play video when new video selected
    private YouTubePlayer youTubePlayer;
    private ArrayList<String> videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        setTitle("Profile");
        db= new WorkoutUserManager(getApplicationContext());

        // Below are the random videos for testing purposes
        // put the appropriate ones when the youtube fragment works
        videoList=new ArrayList<String>();
        videoList.add("CqhpNxI8qYw");
        videoList.add("sasCrpgHDy8");

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