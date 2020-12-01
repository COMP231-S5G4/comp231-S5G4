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

public class ForgotPasswordActivity extends AppCompatActivity {
    private WorkoutUserManager workoutUserManager;
    private EditText usernameText;
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_one);
        workoutUserManager= new WorkoutUserManager(this);
        usernameText = (EditText) findViewById(R.id.usernameText);
        try {
            workoutUserManager = new WorkoutUserManager(this);
        }
        catch(Exception exception)
        {
            Toast.makeText(this,
                    exception.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("Error: ",exception.getMessage());
        }
    }
    public void resetNext(View view){
        usernameText.setTextColor(Color.BLACK);
        Boolean isError=true;

        if(!usernameText.getText().toString().equals("")){
            username = usernameText.getText().toString();
        }
        else{
            usernameText.requestFocus();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error!!");
            builder.setMessage("Enter the Username");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            isError=false;
        }
        if(isError) {
            try {
                int userId = WorkoutUser.convertUsernameToUniqueId(username);
                WorkoutUser wUser = workoutUserManager.getWorkoutUserById(userId, "username");
                if (wUser != null) {
                    SharedPreferences myPreference =
                            getSharedPreferences("WorkoutUserSharedPreferences", MODE_PRIVATE);
                    SharedPreferences.Editor prefEditor = myPreference.edit();
                    prefEditor.clear();
                    prefEditor.putInt("userId", userId);
                    prefEditor.commit();
                    Intent intent = new Intent(this, ForgotPasswordTwoActivity.class);
                    startActivity(intent);
                } else {
                    usernameText.setTextColor(Color.RED);
                    // Error Dialog Box
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Error!!");
                    builder.setMessage("Username does not Exists");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    isError = false;
                }
            } catch (Exception exception) {
                Toast.makeText(this,
                        exception.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("Error: ", exception.getMessage());

            }
        }
    }
}