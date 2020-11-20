package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PopUpActivity extends AppCompatActivity {

    TextView heading;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

        heading = (TextView)findViewById(R.id.exerciseTitleTextview);

        Intent intent = getIntent();
        String title = intent.getStringExtra("dayTitle");
        heading.setText(title);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

         int width = dm.widthPixels;
         int height = dm.heightPixels;

         getWindow().setLayout((int)(width*.8),(int)(height*.5));
    }
}