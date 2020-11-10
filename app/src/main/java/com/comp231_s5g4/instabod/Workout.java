package com.comp231_s5g4.instabod;
import java.util.ArrayList;

public class Workout {
    private int age;
    private int rfm;
    private String gender;
    private String workoutName;
    private int reps;
    private String videoHyperlink;

    public int getAge() {
        return age;
    }

    public int getRfm() {
        return rfm;
    }

    public String getGender() {
        return gender;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public int getReps() {
        return reps;
    }

    public String getVideoHyperlink() {
        return videoHyperlink;
    }

    public Workout(int age, int rfm, String gender, String workoutName, int reps, String videoHyperlink) {
        this.age = age;
        this.rfm = rfm;
        this.gender = gender;
        this.workoutName = workoutName;
        this.reps = reps;
        this.videoHyperlink = videoHyperlink;
    }
}


