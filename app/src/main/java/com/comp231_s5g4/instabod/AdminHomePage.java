package com.comp231_s5g4.instabod;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class AdminHomePage extends AppCompatActivity
{
    ListView workoutUserList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
        workoutUserList = findViewById(R.id.workout_user_list);
    }

    public void search(View v){
        EditText searchEditText = findViewById(R.id.searchEditText);
        int id = WorkoutUser.convertUsernameToUniqueId(searchEditText.getText().toString());
        WorkoutUserManager db = new WorkoutUserManager(this);
        WorkoutUser userList = new WorkoutUser();
        try{
            userList = db.getWorkoutUserById(id,"username");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(userList != null){
            ArrayList<WorkoutUser> workoutUsers = new ArrayList<WorkoutUser>();
            workoutUsers.add(userList);
            AdminListAdapter adapter = new AdminListAdapter(this,R.layout.admin_userlist_layout, workoutUsers);
            workoutUserList.setAdapter(adapter);
        }
        else{
            Toast.makeText(this, "Username does not exist", Toast.LENGTH_LONG).show();
        }
    }


    public void logout(View v){
        SharedPreferences sharedPreferences = getSharedPreferences("WorkoutUserSharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("username");
        editor.remove("password");
        editor.remove("id");
        editor.apply();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}