package com.gppmds.tra.temremdioa;

import android.os.Build;

import com.gppmds.tra.temremdioa.controller.ParseInitializer;
import com.tra.gppmds.temremdioa.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Usuário on 08/06/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class ParseInitializerTest {

    private ParseInitializer parseInitializer;
//    private ParseInitializer applicationParse;


    @Before
    public void setUp() {
        parseInitializer = new ParseInitializer();
//        applicationParse = ApplicationTestUtil.newApplication(ParseInitializer.class);
    }

    @Test
    public void registerParserSubClassesTest(){
        assertTrue(parseInitializer.registerParserSubClasses());
    }

    @Test
    public void inicializeParserTest(){
//        applicationParse.registerParserSubClasses();
//        assertTrue(applicationParse.inicializeParser());
    }

}
