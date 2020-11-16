package com.comp231_s5g4.instabod;
import java.util.ArrayList;

public class Workout {
    private int age;
    private int rfm;
    private String gender;
    private String workoutName;
    private int repetition;
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

    public int getRepetition() {
        return repetition;
    }

    public String getVideoHyperlink() {
        return videoHyperlink;
    }

    public Workout(int age, int rfm, String gender, String workoutName, int repetition, String videoHyperlink) {
        this.age = age;
        this.rfm = rfm;
        this.gender = gender;
        this.workoutName = workoutName;
        this.repetition = repetition;
        this.videoHyperlink = videoHyperlink;
    }
}


