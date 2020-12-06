package com.comp231_s5g4.instabod;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WorkoutUnitTest {
    private Workout workout;

    @Before
    public void setup(){
        workout = new Workout(45,69, "male", "workout1234", 3, "hyperlink");
    }

    @After
    public void tearDown(){
        System.out.println("Testing Finished");
    }

    @Test
    public void testAge(){
        int age = workout.getAge();
        assertEquals("Workout is not returning the expected age number", 45, age);
    }

    @Test
    public void testRfm(){
        int rfm = workout.getRfm();
        assertEquals("Workout is not returning the expected rfm number", 69, rfm);
    }

    @Test
    public void testGender(){
        String gender = workout.getGender();
        assertEquals("Workout is not returning the expected gender", "male", gender);
    }

    @Test
    public void testWorkoutName() {
        String workoutName = workout.getWorkoutName();
        assertEquals("Workout is not returning the expected workout name", "workout1234", workoutName);
    }
    @Test
    public void testRepetition(){
        int repetition = workout.getRepetition();
        assertEquals("Workout is not returning the expected repetition number", 3, repetition);
    }

    @Test
    public void testHyperLink(){
        String hyperlink = workout.getVideoHyperlink();
        assertEquals("Workout is not returning the expected hyperlink", "hyperlink", hyperlink);
    }

}
