package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.widget.TextView;

import java.util.ArrayList;

public class PopUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);
        //getting all the views
        TextView heading = findViewById(R.id.exerciseTitleTextview);
        //workout1
        TextView name1 = findViewById(R.id.exerciseName_Textview);
        TextView reps1 = findViewById(R.id.exerciseReps_Textview);
        TextView hyperlink1 = findViewById(R.id.hyperlink_Textview);
        //workout2
        TextView name2 = findViewById(R.id.exerciseName2_Textview);
        TextView reps2 = findViewById(R.id.exerciseReps2_Textview);
        TextView hyperlink2 = findViewById(R.id.hyperlink2_Textview);
        //workout3
        TextView name3 = findViewById(R.id.exerciseName3_Textview);
        TextView reps3 = findViewById(R.id.exerciseReps3_Textview);
        TextView hyperlink3 = findViewById(R.id.hyperlink3_Textview);

        Intent intent = getIntent();
        String title = intent.getStringExtra("dayTitle");
        heading.setText(title);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .6));
        //setting the workouts
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            //workout1
            name1.setText(name1.getText() + bundle.getString("workout1Name"));
            reps1.setText(reps1.getText() + Integer.toString(bundle.getInt("workout1Reps")));
            hyperlink1.setText(hyperlink1.getText() + bundle.getString("workout1HyperLink"));
            //workout2
            name2.setText(name2.getText() + bundle.getString("workout2Name"));
            reps2.setText(reps2.getText() + Integer.toString(bundle.getInt("workout2Reps")));
            hyperlink2.setText(hyperlink2.getText() + bundle.getString("workout2HyperLink"));
            //workout3
            name3.setText(name3.getText() + bundle.getString("workout3Name"));
            reps3.setText(reps3.getText() + Integer.toString(bundle.getInt("workout3Reps")));
            hyperlink3.setText(hyperlink3.getText() + bundle.getString("workout3HyperLink"));
        }
    }
}