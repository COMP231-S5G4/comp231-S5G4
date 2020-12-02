package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class ForgotPasswordTwoActivity extends AppCompatActivity {
    private WorkoutUserManager workoutUserManager;
    private EditText securityFirstQuestionText, securityFirstAnswerText, securitySecondQuestionText, securitySecondAnswerText, passwordText;
    private int userID;
    private String securityFirstAnswer, securitySecondAnswer, enteredPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_two);

        securityFirstQuestionText = (EditText) findViewById(R.id.securityQuestion1Text);
        securityFirstAnswerText = (EditText) findViewById(R.id.securityAnswer1Text);
        securitySecondQuestionText = (EditText) findViewById(R.id.securityQuestion2Text);
        securitySecondAnswerText = (EditText) findViewById(R.id.securityAnswer2Text);
        passwordText = (EditText) findViewById(R.id.passwordText);

        SharedPreferences sharedPreferences =  getSharedPreferences("WorkoutUserSharedPreferences", MODE_PRIVATE);
        userID = sharedPreferences.getInt("userId",-1);
        try {
            workoutUserManager = new WorkoutUserManager(this);
            WorkoutUser workoutUser = workoutUserManager.getWorkoutUserById(userID, "username");
            securityFirstQuestionText.setText(workoutUser.getSecurityQ1());
            securitySecondQuestionText.setText(workoutUser.getSecurityQ2());
        }
        catch (Exception exception)
        {
            Toast.makeText(this,
                    exception.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("Error: ",exception.getMessage());
        }
    }
    public void resetPassword(View view) {
        securityFirstQuestionText.setTextColor(Color.BLACK);
        securityFirstAnswerText.setTextColor(Color.BLACK);
        securitySecondQuestionText.setTextColor(Color.BLACK);
        securitySecondAnswerText.setTextColor(Color.BLACK);
        passwordText.setTextColor(Color.BLACK);
        Boolean isError=true;
        if(!securityFirstAnswerText.getText().toString().equals("")){
            securityFirstAnswer = securityFirstAnswerText.getText().toString();
        }
        else{
            securityFirstAnswerText.requestFocus();
            isError=false;
        }

        if(!securitySecondAnswerText.getText().toString().equals("")){
            securitySecondAnswer = securitySecondAnswerText.getText().toString();
        }
        else{
            securitySecondAnswerText.requestFocus();
            isError=false;
        }
        if(!passwordText.getText().toString().equals("")){
            if(Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$", passwordText.getText().toString()))
            {
                enteredPassword = passwordText.getText().toString();
            }
            else{
                passwordText.setTextColor(Color.RED);
                // Error Dialog Box
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Invalid Password");
                builder.setMessage("The password must be at least 6 character, one Uppercase, one special character, one number").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                isError=false;
            }
        }
        else{
            passwordText.requestFocus();
            isError=false;
        }
        if(isError){
            try {
                WorkoutUser wUser = workoutUserManager.getWorkoutUserById(userID, "username");
                if(securityFirstAnswer.equals(wUser.getSecurityA1()) &&
                        securitySecondAnswer.equals(wUser.getSecurityA2())){
                    ContentValues cv=new ContentValues();
                    cv.put("password",enteredPassword);
                    workoutUserManager.updateWorkoutUserRow(userID,"username",cv);
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Reset Password Successful");
                    builder.setMessage("Your password is changed successfully");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    //Toast.makeText(getApplicationContext(),"The answers are correct",Toast.LENGTH_LONG).show();
                }
                else{
                    securityFirstAnswerText.setTextColor(Color.RED);
                    securitySecondAnswerText.setTextColor(Color.RED);
                    // Error Dialog Box
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Error to reset the password");
                    builder.setMessage("Incorrect Answers");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    isError=false;
                }
            }
            catch (Exception exception)
            {
                Toast.makeText(this,
                        exception.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("Error: ",exception.getMessage());

            }
        }
    }
}