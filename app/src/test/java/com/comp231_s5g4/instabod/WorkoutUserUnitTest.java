package com.comp231_s5g4.instabod;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WorkoutUserUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void convertToUniqueId_isCorrect(){
        String username = "iamUser1";
        int uniqueId = WorkoutUser.convertUsernameToUniqueId(username);
        assertEquals(uniqueId, 567);
    }
}