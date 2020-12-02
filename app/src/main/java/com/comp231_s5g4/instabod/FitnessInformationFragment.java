package com.comp231_s5g4.instabod;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class FitnessInformationFragment extends Fragment {

    private TextView rfmScoreTextView, pushUpScoreTextView, situpScoreTextView;
    private int userID;
    private WorkoutUserManager db;
    private SharedPreferences sharedPreferences;


    public FitnessInformationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fitnessInfoView = inflater.inflate(R.layout.fragment_fitness_information, container, false);

        rfmScoreTextView = (TextView) fitnessInfoView.findViewById(R.id.rfmValue_textview);
        pushUpScoreTextView = (TextView) fitnessInfoView.findViewById(R.id.pushupScore_textview);
        situpScoreTextView = (TextView) fitnessInfoView.findViewById(R.id.situpScore_textview);
        return fitnessInfoView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        sharedPreferences =  getActivity().getSharedPreferences("WorkoutUserSharedPreferences", MODE_PRIVATE);
        userID = sharedPreferences.getInt("userId",-1);
        try {
            db = new WorkoutUserManager(getActivity());
            WorkoutUser workoutUser = db.getWorkoutUserById(userID, "username");

            rfmScoreTextView.setText(Double.toString(workoutUser.getRfm()) + "%");
            pushUpScoreTextView.setText(Integer.toString(workoutUser.getPushUpScore()) + " push ups until exhausted");
            situpScoreTextView.setText(Integer.toString(workoutUser.getSitUpScore()) + " sit ups in a minute");
        }
        catch (Exception exception)
        {
            Toast.makeText(getActivity(),
                    exception.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("Error: ",exception.getMessage());
        }
    }
}