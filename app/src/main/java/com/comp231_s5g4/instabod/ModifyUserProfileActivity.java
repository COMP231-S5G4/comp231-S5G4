package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyUserProfileActivity extends AppCompatActivity {

    private WorkoutUserManager workoutuserManager;

    private EditText editHeightText, editWaistText, editPushupText,situpEditText,frequencyEditText ;
    private Button modifyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user_profile);
        editHeightText = (EditText) findViewById(R.id.editHeightText);
        editWaistText = (EditText) findViewById(R.id.editWaistText);
        editPushupText = (EditText) findViewById(R.id.editPushupText);
        situpEditText = (EditText) findViewById(R.id.situpEditText);
        frequencyEditText = (EditText) findViewById(R.id.frequencyEditText);
        modifyButton = (Button)findViewById(R.id.button);

        /*Populating the fields with the User Data
           - Uncomment this logic when the User Registration is done in the Iteration2
        */
//        try {
//            WorkoutUser workoutUser = workoutuserManager.getWorkoutUserById(WorkoutUser.convertUsernameToUniqueId(null), "WorkoutUserId");
//            editHeightText.setText((int) workoutUser.getHeight());
//            editWaistText.setText((int)workoutUser.getWaistCircumference());
//            editPushupText.setText( workoutUser.getPushUpScore());
//            situpEditText.setText( workoutUser.getSitUpScore());
//            frequencyEditText.setText( workoutUser.getFrequencyOfExercise());
//        }
//        catch (Exception exception)
//        {
//            Toast.makeText(ModifyUserProfileActivity.this,
//                    exception.getMessage(), Toast.LENGTH_SHORT).show();
//            Log.i("Error: ",exception.getMessage());
//        }
    }

    public void modifyUserProfile(View view) {
    //Code Pushing the Updated text field data will go here after the registration part is done in iteration 2
    }

}
}