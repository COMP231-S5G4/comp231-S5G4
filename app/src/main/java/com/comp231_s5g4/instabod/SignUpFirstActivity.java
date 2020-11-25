package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

public class SignUpFirstActivity extends AppCompatActivity {

    private WorkoutUserManager workoutUserManager;
    private EditText usernameText, passwordText;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_first);

        workoutUserManager= new WorkoutUserManager(this);
        usernameText = (EditText) findViewById(R.id.usernameText);
        passwordText = (EditText) findViewById(R.id.passwordText);
    }

    //On click Method for the Next Button
    public void registerNext(View v){

        usernameText.setTextColor(Color.BLACK);
        passwordText.setTextColor(Color.BLACK);

        Boolean isError=true;

        if(!usernameText.getText().toString().equals("")){
            username = usernameText.getText().toString();
        }
        else{
            usernameText.requestFocus();
            isError=false;
        }
        if(!passwordText.getText().toString().equals("")){
            if(Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$", passwordText.getText().toString()))
            {
                password = passwordText.getText().toString();
            }
            else{
                passwordText.setTextColor(Color.RED);
                // Error Dialog Box
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Invalid Password");
                builder.setMessage("The password must be at least 6 character, one Uppercase, one special character, one number");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                isError=false;
            }
        }
        else{
            passwordText.requestFocus();
            isError=false;
        }
        if(isError){
            try {
                int userId = WorkoutUser.convertUsernameToUniqueId(username);
                WorkoutUser wUser = workoutUserManager.getWorkoutUserById(userId, "username");
                if(wUser==null){
                    SharedPreferences myPreference =
                            getSharedPreferences("WorkoutUserSharedPreferences", 0);
                    SharedPreferences.Editor prefEditor = myPreference.edit();
                    prefEditor.putInt("userId", userId);
                    prefEditor.putString("username", username);
                    prefEditor.putString("password", password);
                    prefEditor.commit();
                    Intent intent = new Intent(this, SignUpSecondActivity.class);
                    startActivity(intent);
                }
                else{
                    usernameText.setTextColor(Color.RED);
                    // Error Dialog Box
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Username Already Exists");
                    builder.setMessage("Enter a different Username");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                }
            }
            catch (Exception exception)
            {
                Toast.makeText(SignUpFirstActivity.this,
                        exception.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("Error: ",exception.getMessage());

            }
        }
    }
}