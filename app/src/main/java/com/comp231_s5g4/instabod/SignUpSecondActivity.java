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
        workoutUserPref = getSharedPreferences("WorkoutUserSharedPreferences", MODE_PRIVATE);

        ArrayList<String> genderList=new ArrayList<String>();
        genderList.add("Male");
        genderList.add("Female");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,genderList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        genderSpinner = findViewById(R.id.genderSpinner);
        genderSpinner.setAdapter(adapter);

        dateOfBirthText = (EditText) findViewById(R.id.dateOfBirthText);
        //genderText = (EditText) findViewById(R.id.genderText);
        securityFirstQuestionText = (EditText) findViewById(R.id.securityFirstQuestionText);
        securityFirstAnswerText = (EditText) findViewById(R.id.securityFirstAnswerText);
        securitySecondQuestionText = (EditText) findViewById(R.id.securitySecondQuestionText);
        securitySecondAnswerText = (EditText) findViewById(R.id.securitySecondAnswerText);
    }

    //On click Method for the Next Button
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void registerNext(View v) throws ParseException {

        dateOfBirthText.setTextColor(Color.BLACK);
        genderText.setTextColor(Color.BLACK);
        securityFirstQuestionText.setTextColor(Color.BLACK);
        securityFirstAnswerText.setTextColor(Color.BLACK);
        securitySecondQuestionText.setTextColor(Color.BLACK);
        securitySecondAnswerText.setTextColor(Color.BLACK);

        Boolean isError=true;

        if(!dateOfBirthText.getText().toString().equals("")){
            dateOfBirth = dateOfBirthText.getText().toString();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date d = sdf.parse(dateOfBirth);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH) + 1;
            int date = c.get(Calendar.DATE);
            LocalDate l1 = LocalDate.of(year, month, date);
            LocalDate now1 = LocalDate.now();
            Period diff1 = Period.between(l1, now1);

            if(diff1.getYears() >= 15)
            {
                //Setting the age
                age = diff1.getYears();
            }
            else{
                // Error Dialog Box
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Ineligible!!!");
                builder.setMessage("18 years and under cannot sign up");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
            }
        }
        else{
            dateOfBirthText.requestFocus();
            isError=false;
        }

        if(!genderText.getText().toString().equals("")){
            gender = genderText.getText().toString();
        }
        else{
            genderText.requestFocus();
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