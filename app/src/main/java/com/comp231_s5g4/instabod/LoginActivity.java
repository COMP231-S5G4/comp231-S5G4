package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText UsernameEditText;
    EditText PasswordEditText;
    Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton = findViewById(R.id.loginButton);
        UsernameEditText = findViewById(R.id.usernameText);
        PasswordEditText = findViewById(R.id.editWaistText);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = UsernameEditText.getText().toString();
                String password = PasswordEditText.getText().toString();

                Boolean isError=true;
                if(username.equals("") || password.equals("")){
                    isError=false;
                }

                if(isError){
                    //Valid Data
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