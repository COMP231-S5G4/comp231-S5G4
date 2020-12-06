package com.comp231_s5g4.instabod;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class SignUpSecondActivity extends AppCompatActivity {

    private  EditText dateOfBirthText, genderText, securityFirstQuestionText, securityFirstAnswerText, securitySecondQuestionText, securitySecondAnswerText;
    private SharedPreferences workoutUserPref;
    private String dateOfBirth, gender, securityFirstQuestion, securityFirstAnswer, securitySecondQuestion, securitySecondAnswer;
    private Spinner genderSpinner;
    private int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_second);
        setTitle("Sign Up");
        workoutUserPref = getSharedPreferences("WorkoutUserSharedPreferences", MODE_PRIVATE);

        ArrayList<String> genderList=new ArrayList<String>();
        genderList.add("Male");
        genderList.add("Female");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,genderList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        genderSpinner = findViewById(R.id.genderSpinner);
        genderSpinner.setAdapter(adapter);

        dateOfBirthText = (EditText) findViewById(R.id.dateOfBirthText);
        securityFirstQuestionText = (EditText) findViewById(R.id.securityFirstQuestionText);
        securityFirstAnswerText = (EditText) findViewById(R.id.securityFirstAnswerText);
        securitySecondQuestionText = (EditText) findViewById(R.id.securitySecondQuestionText);
        securitySecondAnswerText = (EditText) findViewById(R.id.securitySecondAnswerText);
    }

    //On click Method for the Next Button
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void signUpButton(View v) throws ParseException {

        dateOfBirthText.setTextColor(Color.BLACK);
        securityFirstQuestionText.setTextColor(Color.BLACK);
        securityFirstAnswerText.setTextColor(Color.BLACK);
        securitySecondQuestionText.setTextColor(Color.BLACK);
        securitySecondAnswerText.setTextColor(Color.BLACK);

        //Getting the Gender from the Spinner
        gender = genderSpinner.getSelectedItem().toString();

        Boolean isError=true;

        if(!dateOfBirthText.getText().toString().equals("")){
            dateOfBirth = dateOfBirthText.getText().toString();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String user="";
            String currentDate=sdf.format(new Date());
            try {
                user = sdf.format(sdf.parse(dateOfBirth));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int currentYear = Integer.parseInt(currentDate.substring(0,4));
            int currentMonth = Integer.parseInt(currentDate.substring(5,7));
            int currentDay = Integer.parseInt(currentDate.substring(8,10));
            int birthYear = Integer.parseInt(user.substring(0,4));
            int birthMonth = Integer.parseInt(dateOfBirth.substring(5,7));
            int birthDay = Integer.parseInt(dateOfBirth.substring(8,10));
            int age =currentYear-birthYear;

            if(currentMonth<birthMonth){
                age--;
            }
            else{
                if(currentDay < birthDay){
                    age--;
                }
            }

            if(age >= 15)
            {
                //Setting the age
                this.age = age;
            }
            else{
                // Error Dialog Box
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Ineligible!!!");
                builder.setMessage("15 years and under cannot sign up").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
            dateOfBirthText.requestFocus();
            isError=false;
        }

        if(!securityFirstQuestionText.getText().toString().equals("")){
            securityFirstQuestion = securityFirstQuestionText.getText().toString();
        }
        else{
            securityFirstQuestionText.requestFocus();
            isError=false;
        }

        if(!securityFirstAnswerText.getText().toString().equals("")){
            securityFirstAnswer = securityFirstAnswerText.getText().toString();
        }
        else{
            securityFirstAnswerText.requestFocus();
            isError=false;
        }

        if(!securitySecondQuestionText.getText().toString().equals("")){
            securitySecondQuestion = securitySecondQuestionText.getText().toString();
        }
        else{
            securitySecondQuestionText.requestFocus();
            isError=false;
        }

        if(!securitySecondAnswerText.getText().toString().equals("")){
            securitySecondAnswer = securitySecondAnswerText.getText().toString();
        }
        else{
            securitySecondAnswerText.requestFocus();
            isError=false;
        }

        if(isError){
            try {
                    SharedPreferences.Editor prefEditor = workoutUserPref.edit();
                    prefEditor.putInt("age", age);
                    prefEditor.putString("gender", gender);
                    prefEditor.putString("securityFirstQuestion", securityFirstQuestion);
                    prefEditor.putString("securityFirstAnswer", securityFirstAnswer);
                    prefEditor.putString("securitySecondQuestion", securitySecondQuestion);
                    prefEditor.putString("securitySecondAnswer", securitySecondAnswer);
                    prefEditor.commit();
                    Intent intent = new Intent(this, UserProfileActivity.class);
                    startActivity(intent);
            }
            catch (Exception exception)
            {
                Toast.makeText(SignUpSecondActivity.this,
                        exception.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("Error: ",exception.getMessage());
            }
        }
    }
}