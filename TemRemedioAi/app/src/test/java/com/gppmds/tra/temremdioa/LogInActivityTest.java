package com.gppmds.tra.temremdioa;

import org.junit.Test;
import com.gppmds.tra.temremdioa.controller.LogInActivity;

import static org.junit.Assert.*;

/**
 * Created by levimoraes on 09/06/16.
 */
public class LogInActivityTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void newCorrect() throws Exception{
        assertEquals("casa","casa");
    }

    @Test
    public void isPasswordValidTest(){
        String password = "casa";
        LogInActivity newLogin = new LogInActivity();
        assertEquals(false,newLogin.returnIsPasswordValid(password));
    }
}
