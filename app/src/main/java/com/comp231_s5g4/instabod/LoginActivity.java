package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.System.exit;

public class
LoginActivity extends AppCompatActivity {

    EditText UsernameEditText;
    EditText PasswordEditText;
    Button LoginButton;
    private final static String TABLE_NAME = "WorkoutUser";
    private static final String tableCreatorString =
            "CREATE TABLE "+ TABLE_NAME + " (username integer primary key, password text, age integer, gender text, securityQuestion1 text, securityAnswer1 text, " +
                    "securityQuestion2 text, securityAnswer2 text, height numeric, waistCircumference numeric, rfm numeric," +
                    "pushUpScore integer, sitUpScore integer, frequencyOfExercise integer);";
    WorkoutUserManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db= new WorkoutUserManager(getApplicationContext());
        db.workoutUserDbInitialize(TABLE_NAME,tableCreatorString);

        LoginButton = findViewById(R.id.loginButton);
        UsernameEditText = findViewById(R.id.usernameText);
        PasswordEditText = findViewById(R.id.editWaistText);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = UsernameEditText.getText().toString();
                String password = PasswordEditText.getText().toString();
                WorkoutUser workoutUser = new WorkoutUser();
                Boolean isError=true;
                if(username.equals("") || password.equals("")){
                    isError=false;
                }
                if(isError){
                    int convertedUsername=WorkoutUser.convertUsernameToUniqueId(username);
                    try {
                        workoutUser=db.getWorkoutUserById(convertedUsername,"username");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(workoutUser==null){
                        UsernameEditText.setTextColor(Color.RED);
                        Toast.makeText(getApplicationContext(),"User does not Exists",Toast.LENGTH_LONG).show();
                    }
                    else{
                        if(password.equals("SpecialPerson@1234") && username.equals("superuser")){
                            SharedPreferences shared = getSharedPreferences(getResources().getString(R.string.sharedpreference), Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = shared.edit();
                            editor.putString("username",username);
                            editor.putInt("id",convertedUsername);
                            editor.putString("password",password);
                            editor.apply();
                            UsernameEditText.setTextColor(Color.BLACK);
                            startActivity(new Intent(getApplicationContext(),AdminHomePage.class));
                        }
                        else if(password.equals(workoutUser.getPassword())){
                            // Username & password Valid
                            SharedPreferences shared = getSharedPreferences(getResources().getString(R.string.sharedpreference), Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = shared.edit();
                            editor.putString("username",username);
                            editor.putInt("id",convertedUsername);
                            editor.putString("password",password);
                            editor.apply();
                            UsernameEditText.setTextColor(Color.BLACK);
                            startActivity(new Intent(getApplicationContext(),WorkoutPlanActivity.class));
                        }
                        else{
                            UsernameEditText.setTextColor(Color.RED);
                            Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else{
                    if(username.equals("")){
                        UsernameEditText.requestFocus();
                        Toast.makeText(getApplicationContext(),"Please Enter your username",Toast.LENGTH_LONG).show();
                    }
                    else if(password.equals("")){
                        PasswordEditText.requestFocus();
                        Toast.makeText(getApplicationContext(),"Please Enter your password",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
    }
    public void forgotPassword(View view)
    {
        startActivity(new Intent(getApplicationContext(),ForgotPasswordActivity.class));
    }
    public void signUp(View view)
    {
        startActivity(new Intent(getApplicationContext(),SignUpFirstActivity.class));
    }
}
