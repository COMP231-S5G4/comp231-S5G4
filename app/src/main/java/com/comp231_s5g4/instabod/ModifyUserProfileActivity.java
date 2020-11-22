package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyUserProfileActivity extends AppCompatActivity {

    private WorkoutUserManager workoutuserManager;

    private EditText editHeightText, editWaistText, editPushupText,situpEditText,frequencyEditText ;
    private Button button;
    private final static String TABLE_NAME = "WorkoutUser";
    //sql string to create the table
    private static final String tableCreatorString =
            "CREATE TABLE "+ TABLE_NAME + " (WorkoutUserId integer primary key,editHeightText text,editWaistText text,editPushupText text,situpEditText text,frequencyEditText text);";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user_profile);
        editHeightText = (EditText) findViewById(R.id.editHeightText);
        editWaistText = (EditText) findViewById(R.id.editWaistText);
        editPushupText = (EditText) findViewById(R.id.editPushupText);
        situpEditText = (EditText) findViewById(R.id.situpEditText);
        frequencyEditText = (EditText) findViewById(R.id.frequencyEditText);
        button = (Button)findViewById(R.id.button);
        try {
            workoutuserManager = new WorkoutUserManager(this);
            //create the table
            workoutuserManager.workoutUserDbInitialize(TABLE_NAME, tableCreatorString);
        }
        catch(Exception exception)
        {
            Toast.makeText(ModifyUserProfileActivity.this,
                    exception.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("Error: ",exception.getMessage());
        }



    }

    public void showWorkoutUser(View view)
    {
        try {
            WorkoutUser workoutUser = workoutuserManager.getWorkoutUserById(WorkoutUser.convertUsernameToUniqueId(null), "WorkoutUserId");
            editHeightText.setText((int) workoutUser.getHeight());
            editWaistText.setText((int)workoutUser.getWaistCircumference());
            editPushupText.setText((int) workoutUser.getPushUpScore());
            situpEditText.setText((int) workoutUser.getSitUpScore());
            frequencyEditText.setText((int) workoutUser.getFrequencyOfExercise());

        }
        catch (Exception exception)
        {
            Toast.makeText(ModifyUserProfileActivity.this,
                    exception.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("Error: ",exception.getMessage());

        }

}
}