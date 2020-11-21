package com.comp231_s5g4.instabod;

import java.util.ArrayList;

public class WorkoutAlgorithm {
    public ArrayList<Workout> weeklyWorkouts;
    InstabodWorkouts workouts;
    private int RFM,age,gender;

    public WorkoutAlgorithm(int RFM, int age,int gender) {
        this.RFM = RFM;
        this.age = age;
        this.gender = gender;
    }
    //Temporary age is integer where 1 = male and 0 = female
    WorkoutAlgorithm(){
        RFM=18;
        age = 20;
        gender = 1;
        workouts = new InstabodWorkouts();
        weeklyWorkouts = new ArrayList<Workout>();
    }

    ArrayList<Workout> generateWorkout(){
        filerWorkoutData();
        int size=weeklyWorkouts.size();
        return weeklyWorkouts;
    }

    void filerWorkoutData(){
        int tempRFM,tempAge;
        String tempGender;
        if(gender == 1){
            tempGender = "Male";
            if(age >= 60){
                if(RFM>=2 && RFM<= 5){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=60 && tempRFM >= 2 && tempRFM <=5 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM>= 6 && RFM <= 13){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=60 && tempRFM >= 6 && tempRFM <=13 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >=14 && RFM <=17){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=60 && tempRFM >= 14 && tempRFM <=17 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >=18 && RFM <=24){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=60 && tempRFM >= 18 && tempRFM <=24 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >= 25){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=60 && tempRFM >= 25 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
            }
            else if(age >= 30){
                if(RFM>=2 && RFM<= 5){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=30 && tempRFM >= 2 && tempRFM <=5 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM>= 6 && RFM <= 13){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=30 && tempRFM >= 6 && tempRFM <=13 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >=14 && RFM <=17){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=30 && tempRFM >= 14 && tempRFM <=17 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >=18 && RFM <=24){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=30 && tempRFM >= 18 && tempRFM <=24 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >= 25){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=30 && tempRFM >= 25 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
            }
            else{
                if(RFM>=2 && RFM<= 5){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempRFM >= 2 && tempRFM <=5 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM>= 6 && RFM <= 13){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempRFM >= 6 && tempRFM <=13 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >=14 && RFM <=17){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempRFM >= 14 && tempRFM <=17 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >=18 && RFM <=24){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempRFM >= 18 && tempRFM <=24 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >= 25){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempRFM >= 25 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
            }
        }
        else if(gender == 0){
            tempGender = "Female";
            if(age >= 60){
                if(RFM>=10 && RFM<= 13){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=60 && tempRFM >= 10 && tempRFM <=13 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM>= 14 && RFM <= 20){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=60 && tempRFM >= 10 && tempRFM <=13 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >=21 && RFM <=24){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=60 && tempRFM >= 10 && tempRFM <=13 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >=25 && RFM <=31){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=60 && tempRFM >= 10 && tempRFM <=13 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >= 32){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=60 && tempRFM >= 10 && tempRFM <=13 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
            }
            else if(age >= 30){
                if(RFM>=10 && RFM<= 13){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=30 && tempRFM >= 10 && tempRFM <=13 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM>= 14 && RFM <= 20){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=30 && tempRFM >= 10 && tempRFM <=13 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >=21 && RFM <=24){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=30 && tempRFM >= 10 && tempRFM <=13 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >=25 && RFM <=31){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=30 && tempRFM >= 25 && tempRFM <=31 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >= 32){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempAge >=30 && tempRFM >= 32 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
            }
            else{
                if(RFM>=10 && RFM<= 13){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempRFM >= 10 && tempRFM <=13 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM>= 14 && RFM <= 20){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempRFM >= 14 && tempRFM <=20 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >=21 && RFM <=24){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempRFM >= 21 && tempRFM <=24 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >=25 && RFM <=31){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempRFM >= 25 && tempRFM <=31 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
                else if(RFM >= 32){
                    for (Workout data:workouts.workoutList) {
                        tempAge = data.getAge();
                        tempRFM = data.getRfm();
                        if(tempRFM >= 32 && tempGender.equals(data.getGender())){
                            weeklyWorkouts.add(data);
                        }
                    }
                }
            }
        }
    }
}
