package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText UsernameEditText;
    EditText PasswordEditText;
    Button LoginButton;

    WorkoutUserManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db= new WorkoutUserManager(getApplicationContext());

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
                        Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_LONG).show();
                    }
                    else{
                        if(password.equals(workoutUser.getPassword())){
                            // Username & password Valid
                            // TODO - Enter the Shared Preference and move to next activity
                            UsernameEditText.setTextColor(Color.BLACK);
                            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
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
}