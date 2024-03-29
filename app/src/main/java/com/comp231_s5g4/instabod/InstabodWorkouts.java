package com.comp231_s5g4.instabod;

import java.util.ArrayList;

public class InstabodWorkouts {

    public static ArrayList<Workout> workoutList;

    InstabodWorkouts(){
        workoutList = new ArrayList<Workout>();

        //For Males
        workoutList.add(new Workout(29, 5, "Male", "Incline Dumbells", 5, "https://youtu.be/0G2_XV7slIg"));
        workoutList.add(new Workout(29, 13, "Male", "Pull Ups", 6, "https://youtu.be/eGo4IYlbE5g"));
        workoutList.add(new Workout(29, 17, "Male", "Flat Dumbell", 7, "https://youtu.be/VmB1G1K7v94"));
        workoutList.add(new Workout(29, 24, "Male", "Crunches", 8, "https://youtu.be/5ER5Of4MOPI"));
        workoutList.add(new Workout(29, 25, "Male", "Jumping Jacks", 20, "https://youtu.be/c4DAnQ6DtF8"));
        workoutList.add(new Workout(29, 25, "Male", "Burpees", 9, "https://youtu.be/qLBImHhCXSw"));
        workoutList.add(new Workout(29, 25, "Male", "Push Up", 10, "https://youtu.be/IODxDxX7oi4"));
        workoutList.add(new Workout(29, 25, "Male", "Squat Jumps", 30, "https://youtu.be/CVaEhXotL7M"));
        workoutList.add(new Workout(29, 25, "Male", "Plank", 3, "https://youtu.be/B296mZDhrP4"));
        workoutList.add(new Workout(29, 25, "Male", "Lunges", 10, "https://youtu.be/wrwwXE_x-pQ"));
        workoutList.add(new Workout(29, 25, "Male", "Standing Calf Raise", 30, "https://youtu.be/_h0v0Jt3ews"));
        workoutList.add(new Workout(29, 25, "Male", "Fast Stepping", 50, "https://youtu.be/DfMbexJKYwQ"));
        workoutList.add(new Workout(29, 25, "Male", "Spine Reverse Crunches", 20, "https://youtu.be/hyv14e2QDq0"));

        workoutList.add(new Workout(49, 5, "Male", "Crunches", 10, "https://youtu.be/5ER5Of4MOPI"));
        workoutList.add(new Workout(49, 13, "Male", "Squats", 5, "https://youtu.be/YaXPRqUwItQ"));
        workoutList.add(new Workout(49, 17, "Male", "Burpees", 5, "https://youtu.be/qLBImHhCXSw"));
        workoutList.add(new Workout(49, 24, "Male", "Leg Raises", 5, "https://youtu.be/JB2oyawG9KI"));
        workoutList.add(new Workout(49, 24, "Male", "Spine Twist", 20, "https://youtu.be/XbQzj8rjBbw"));
        workoutList.add(new Workout(49, 24, "Male", "Spine Reverse Crunches", 20, "https://youtu.be/hyv14e2QDq0"));
        workoutList.add(new Workout(49, 25, "Male", "Jumping Jacks", 20, "https://youtu.be/c4DAnQ6DtF8"));
        workoutList.add(new Workout(49, 25, "Male", "Mountain Climbing", 20, "https://youtu.be/cnyTQDSE884"));
        workoutList.add(new Workout(49, 25, "Male", "Plank", 2, "https://youtu.be/B296mZDhrP4"));
        workoutList.add(new Workout(49, 25, "Male", "Lunges", 5, "https://youtu.be/wrwwXE_x-pQ"));
        workoutList.add(new Workout(49, 25, "Male", "Leg Raises", 10, "https://youtu.be/JB2oyawG9KI"));
        workoutList.add(new Workout(49, 25, "Male", "Standing Calf Raise", 30, "https://youtu.be/_h0v0Jt3ews"));
        workoutList.add(new Workout(49, 25, "Male", "Fast Stepping", 50, "https://youtu.be/DfMbexJKYwQ"));

        workoutList.add(new Workout(60, 5, "Male", "Wall Push Up", 10, "https://youtu.be/HcWr8HWoUas"));
        workoutList.add(new Workout(60, 13, "Male", "Squats", 13, "https://youtu.be/YaXPRqUwItQ"));
        workoutList.add(new Workout(60, 17, "Male", "Toe Touching", 10, "https://youtu.be/qgtktJYqFkg"));
        workoutList.add(new Workout(60, 17, "Male", "Squat Jumps", 10, "https://youtu.be/CVaEhXotL7M"));
        workoutList.add(new Workout(60, 17, "Male", "Spine Twist", 20, "https://youtu.be/XbQzj8rjBbw"));
        workoutList.add(new Workout(60, 24, "Male", "Jumping Jacks", 20, "https://youtu.be/c4DAnQ6DtF8"));
        workoutList.add(new Workout(60, 24, "Male", "Squats", 10, "https://youtu.be/YaXPRqUwItQ"));
        workoutList.add(new Workout(60, 24, "Male", "Mountain Climbing", 10, "https://youtu.be/cnyTQDSE884"));
        workoutList.add(new Workout(60, 25, "Male", "Spot Running", 20, "https://youtu.be/7waVVI7SHVA"));
        workoutList.add(new Workout(60, 25, "Male", "Plank", 3, "https://youtu.be/B296mZDhrP4"));
        workoutList.add(new Workout(60, 25, "Male", "Lunges", 10, "https://youtu.be/wrwwXE_x-pQ"));
        workoutList.add(new Workout(60, 25, "Male", "Leg Raises", 10, "https://youtu.be/JB2oyawG9KI"));
        workoutList.add(new Workout(60, 25, "Male", "Standing Calf Raise", 30, "https://youtu.be/_h0v0Jt3ews"));
        workoutList.add(new Workout(60, 25, "Male", "Fast Stepping", 50, "https://youtu.be/DfMbexJKYwQ"));
        workoutList.add(new Workout(60, 25, "Male", "Squat Jumps", 20, "https://youtu.be/CVaEhXotL7M"));

        //For Females
        workoutList.add(new Workout(29, 13, "Female", "Incline Dumbell", 5, "https://youtu.be/0G2_XV7slIg"));
        workoutList.add(new Workout(29, 13, "Female", "Plank", 5, "https://youtu.be/B296mZDhrP4"));
        workoutList.add(new Workout(29, 20, "Female", "Burpees", 20, "https://youtu.be/qLBImHhCXSw"));
        workoutList.add(new Workout(29, 24, "Female", "Squats", 20, "https://youtu.be/YaXPRqUwItQ"));
        workoutList.add(new Workout(29, 24, "Female", "Spine Reverse Crunches", 20, "https://youtu.be/hyv14e2QDq0"));
        workoutList.add(new Workout(29, 31, "Female", "Crunches", 20, "https://youtu.be/5ER5Of4MOPI"));
        workoutList.add(new Workout(29, 31, "Female", "Jumping Jacks", 20, "https://youtu.be/c4DAnQ6DtF8"));
        workoutList.add(new Workout(29, 31, "Female", "Standing Calf Raise", 30, "https://youtu.be/_h0v0Jt3ews"));
        workoutList.add(new Workout(29, 32, "Female", "Sit Ups", 20, "https://youtu.be/1fbU_MkV7NE"));
        workoutList.add(new Workout(29, 32, "Female", "Push Up", 20, "https://youtu.be/IODxDxX7oi4"));
        workoutList.add(new Workout(29, 32, "Female", "Plank", 30, "https://youtu.be/B296mZDhrP4"));
        workoutList.add(new Workout(29, 32, "Female", "Leg Raises", 30, "https://youtu.be/JB2oyawG9KI"));
        workoutList.add(new Workout(29, 32, "Female", "Fast Stepping", 50, "https://youtu.be/DfMbexJKYwQ"));
        workoutList.add(new Workout(29, 32, "Female", "Mountain Climbing", 40, "https://youtu.be/cnyTQDSE884"));

        workoutList.add(new Workout(49, 13, "Female", "Plank", 5, "https://youtu.be/B296mZDhrP4"));
        workoutList.add(new Workout(49, 20, "Female", "Burpees", 20, "https://youtu.be/qLBImHhCXSw"));
        workoutList.add(new Workout(49, 24, "Female", "Squats", 20, "https://youtu.be/YaXPRqUwItQ"));
        workoutList.add(new Workout(49, 24, "Female", "Spine Reverse Crunches", 20, "https://youtu.be/hyv14e2QDq0"));
        workoutList.add(new Workout(49, 31, "Female", "Squat Jumps", 20, "https://youtu.be/CVaEhXotL7M"));
        workoutList.add(new Workout(49, 31, "Female", "Crunches", 20, "https://youtu.be/5ER5Of4MOPI"));
        workoutList.add(new Workout(49, 32, "Female", "Jumping Jacks", 30, "https://youtu.be/c4DAnQ6DtF8"));
        workoutList.add(new Workout(49, 32, "Male", "Standing Calf Raise", 30, "https://youtu.be/_h0v0Jt3ews"));
        workoutList.add(new Workout(49, 32, "Female", "Sit Ups", 20, "https://youtu.be/1fbU_MkV7NE"));
        workoutList.add(new Workout(49, 32, "Female", "Push Up", 20, "https://youtu.be/IODxDxX7oi4"));
        workoutList.add(new Workout(49, 32, "Female", "Plank", 30, "https://youtu.be/B296mZDhrP4"));
        workoutList.add(new Workout(49, 32, "Female", "Lunges", 30, "https://youtu.be/wrwwXE_x-pQ"));
        workoutList.add(new Workout(49, 32, "Female", "Leg Raises", 20, "https://youtu.be/JB2oyawG9KI"));
        workoutList.add(new Workout(49, 32, "Female", "Fast Stepping", 50, "https://youtu.be/DfMbexJKYwQ"));
        workoutList.add(new Workout(49, 32, "Female", "Mountain Climbing", 30, "https://youtu.be/cnyTQDSE884"));

        workoutList.add(new Workout(60, 13, "Female", "Wall Push Up", 5, "https://youtu.be/HcWr8HWoUas"));
        workoutList.add(new Workout(60, 20, "Female", "Squats", 20, "https://youtu.be/YaXPRqUwItQ"));
        workoutList.add(new Workout(60, 24, "Female", "Toe Touching", 20, "https://youtu.be/qgtktJYqFkg"));
        workoutList.add(new Workout(60, 24, "Female", "Spine Twist", 20, "https://youtu.be/XbQzj8rjBbw"));
        workoutList.add(new Workout(60, 31, "Female", "Spot Running", 20, "https://youtu.be/7waVVI7SHVA"));
        workoutList.add(new Workout(60, 31, "Female", "Squat Jumps", 20, "https://youtu.be/CVaEhXotL7M"));
        workoutList.add(new Workout(60, 32, "Female", "Jumping Jacks", 40, "https://youtu.be/c4DAnQ6DtF8"));
        workoutList.add(new Workout(60, 32, "Female", "Sit Ups", 20, "https://youtu.be/1fbU_MkV7NE"));
        workoutList.add(new Workout(60, 32, "Female", "Lunges", 20, "https://youtu.be/wrwwXE_x-pQ"));
        workoutList.add(new Workout(60, 32, "Female", "Leg Raises", 10, "https://youtu.be/JB2oyawG9KI"));
        workoutList.add(new Workout(60, 32, "Female", "Plank", 30, "https://youtu.be/B296mZDhrP4"));
        workoutList.add(new Workout(60, 32, "Female", "Standing Calf Raise", 30, "https://youtu.be/_h0v0Jt3ews"));
        workoutList.add(new Workout(60, 32, "Female", "Fast Stepping", 50, "https://youtu.be/DfMbexJKYwQ"));
        workoutList.add(new Workout(60, 32, "Female", "Mountain Climbing", 30, "https://youtu.be/cnyTQDSE884"));
    }
}

