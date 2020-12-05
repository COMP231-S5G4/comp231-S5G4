package com.comp231_s5g4.instabod;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class WorkoutAlgorithmUnitTest {
    private WorkoutAlgorithm workoutAlgorithm;
    @Before
    public void setUp(){
        workoutAlgorithm = new WorkoutAlgorithm(24.5d,25,1);
        System.out.println("Ready for the testing");
    }

    @After
    public void tearDown(){
        System.out.println("Testing Finished");
    }

    @Test
    public void testEmptyArray(){
        ArrayList<Workout> workouts = workoutAlgorithm.generateWorkout();
        int size = workouts.size();
        assertEquals("Workout Algorithm is not returning workouts",0,size);
    }

    @Test
    public void testReturnedSize(){
        ArrayList<Workout> workouts = workoutAlgorithm.generateWorkout();
        int size = workouts.size();

        assertEquals("Workout Algorithm is not returing all the valid workouts",7,size);
    }

}
