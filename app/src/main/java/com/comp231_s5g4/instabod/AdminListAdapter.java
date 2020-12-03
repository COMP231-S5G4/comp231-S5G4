package com.comp231_s5g4.instabod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AdminListAdapter extends ArrayAdapter<WorkoutUser>
{
    Context context;
    int resource;

    public AdminListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<WorkoutUser> objects)
    {

        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView=inflater.inflate(resource,parent,false);

        int age = getItem(position).getAge();
        int username = getItem(position).getUserName();
        String gender = getItem(position).getGender();
        double height = getItem(position).getHeight();
        double waist = getItem(position).getWaistCircumference();
        double rfm = getItem(position).getRfm();
        int pushupScore = getItem(position).getPushUpScore();
        int situpScore = getItem(position).getSitUpScore();

        TextView usernameTextview,ageTextview,genderTextview,heightTextview,waistTextview,rfmTextview,pushupScoreTextview,situpScoreTextview;

        usernameTextview = convertView.findViewById(R.id.userNameTextview);
        ageTextview  = convertView.findViewById(R.id.ageTextview);
        genderTextview  = convertView.findViewById(R.id.genderTextview);
        heightTextview  = convertView.findViewById(R.id.listHeightTextview);
        waistTextview  = convertView.findViewById(R.id.listWaistTextview);
        rfmTextview  = convertView.findViewById(R.id.rfmTextview);
        pushupScoreTextview  = convertView.findViewById(R.id.pushupScoreTextview);
        situpScoreTextview  = convertView.findViewById(R.id.situpScoreTextview);

        usernameTextview.setText("Username: "+ username);
        ageTextview.setText("Age: " + age);
        genderTextview.setText("Gender: " + gender);
        heightTextview.setText("Height: " + height);
        waistTextview.setText("Waist: " + waist);
        rfmTextview.setText("RFM:" + rfm);
        pushupScoreTextview.setText("Pushup Score: " + pushupScore);
        situpScoreTextview.setText("Situp Score: " + situpScore);

        return convertView;
    }
}

