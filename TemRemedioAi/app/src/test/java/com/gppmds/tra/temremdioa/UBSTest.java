package com.gppmds.tra.temremdioa;

import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.junit.Before;
import org.junit.Test;

import static java.lang.Double.valueOf;
import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class UBSTest {

    private UBS ubs;
    private static final Double LATITUDE = 3.23;
    private static final Double LONGITUDE = 2.11;

    @Before
    public void setUp() {
        ParseObject.registerSubclass(UBS.class);
        ubs = new UBS();
    }

    @Test
    public void getUbsLatitudeTest() throws Exception {
        ubs.setUbsLatitude(LATITUDE);
        assertEquals(LATITUDE, ubs.getUbsLatitude());
    }

    @Test
    public void getUbsLongitudeTest() throws Exception {
        ubs.setUbsLongitude(LONGITUDE);
        assertEquals(LONGITUDE, ubs.getUbsLongitude());
    }

    @Test
    public void getUbsNameTest() throws Exception {
        ubs.setUbsName("test name");
        assertEquals("test name", ubs.getUbsName());
    }

    @Test
    public void getUbsAddressTest() throws Exception {
        ubs.setUbsAddress("test address");
        assertEquals("test address", ubs.getUbsAddress());
    }

    @Test
    public void getUbsNeighborhoodTest() throws Exception {
        ubs.setUbsNeighborhood("test neighborhood");
        assertEquals("test neighborhood", ubs.getUbsNeighborhood());
    }

    @Test
    public void getUbsCityTest() throws Exception {
        ubs.setUbsCity("test city");
        assertEquals("test city", ubs.getUbsCity());
    }

    @Test
    public void getUbsAttentionLevelTest() throws Exception {
        ubs.setUbsAttentionLevel("test attention level");
        assertEquals("test attention level", ubs.getUbsAttentionLevel());
    }

    @Test
    public void getUbsPhoneTest() throws Exception{
        ubs.setUbsPhone("(61) 5555-5555");
        assertEquals("(61) 5555-5555", ubs.getUbsPhone());
    }

    @Test
    public void toStringTest() throws Exception {
        ubs.setUbsName("test toString");
        assertEquals("test toString", ubs.toString());
    }

    @Test
    public void getQueryTest() {
        assertNotEquals(ubs.getQuery(), ParseQuery.getQuery(UBS.class));
    }
}