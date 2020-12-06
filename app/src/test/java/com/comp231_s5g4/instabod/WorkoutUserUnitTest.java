package com.comp231_s5g4.instabod;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WorkoutUserUnitTest
{
    private WorkoutUser workoutUser;
    @Before
    public void setUp(){
        workoutUser = new WorkoutUser(123,"Ash@368",26,"male","father??","yes","mother??","no",170.0,120.0,26.8,30,40,2);
        System.out.println("Ready for the testing");
    }

    @After
    public void tearDown(){
        System.out.println("Testing Finished");
    }


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void convertToUniqueId_isCorrect(){
        String username = "iamUser1";
        int uniqueId = workoutUser.convertUsernameToUniqueId(username);
        assertEquals(uniqueId, 567);
    }
    @Test
    public void testUserName()
    {
        int username =  workoutUser.getUserName();
        assertEquals("The Username is not valid",123,username);

    }
    @Test
    public void testPassword()
    {
        String password =  workoutUser.getPassword();
        assertEquals("The password entered is not valid","Ash@368",password);

    }
    @Test
    public void testAge()
    {
        int age =  workoutUser.getAge();
        assertEquals("Your age is not valid",26,age);

    }
    @Test
    public void testGender()
    {
        String gender =  workoutUser.getGender();
        assertEquals("The gender is not valid","male",gender);

    }
    @Test
    public void testQuestion1()
    {
        String question1 =  workoutUser.getSecurityQ1();
        assertEquals("The question entered is invalid","father??",question1);

    }
    @Test
    public void testAnswer1()
    {
        String answer1 =  workoutUser.getSecurityA1();
        assertEquals("Incorrect Answer.","yes",answer1);

    }
    @Test
    public void testQuestion2()
    {
        String question2 =  workoutUser.getSecurityQ2();
        assertEquals("The question entered is invalid","mother??",question2);

    }
    @Test
    public void testAnswer2()
    {
        String answer2 =  workoutUser.getSecurityA2();
        assertEquals("Incorrect Answer.","no",answer2);

    }
    @Test
    public void testHeight()
    {
        double height =  workoutUser.getHeight();
        assertEquals("The height entered is invalid",170.0,0,height);

    }
    @Test
    public void testWaist()
    {
        double waist =  workoutUser.getWaistCircumference();
        assertEquals("The waist circumference entered is invalid",120.0,0,waist);

    }
    @Test
    public void testRfm()
    {
        double rfm =  workoutUser.getRfm();
        assertEquals("The RFM result is invalid",26.8d,0,rfm);

    }
    @Test
    public void testPushUpScore()
    {
        int pushupScore =  workoutUser.getPushUpScore();
        assertEquals("The pushup score is not valid",30,pushupScore);

    }
    @Test
    public void testSitUpScore()
    {
        int situpScore =  workoutUser.getSitUpScore();
        assertEquals("The situp score is not valid",40,situpScore);

    }

    @Test
    public void testFrequency()
    {
        int frequency =  workoutUser.getFrequencyOfExercise();
        assertEquals("The frequency entered is not valid",2,frequency);

    }
}