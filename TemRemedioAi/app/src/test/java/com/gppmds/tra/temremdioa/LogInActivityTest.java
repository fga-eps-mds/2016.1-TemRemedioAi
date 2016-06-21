package com.gppmds.tra.temremdioa;

import android.widget.EditText;
import com.gppmds.tra.temremdioa.controller.LogInActivity;
import static org.junit.Assert.*;

import org.junit.Test;

public class LogInActivityTest{
    private LogInActivity logInActivity;

    @Test
    public void valiteErrorTest() {
        EditText text = null;
        text.setText("test");
        assertTrue(logInActivity.validateError("123456", "test", text));
    }
}
