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
public class TestUBS {

    private UBS ubs;

    @Before
    public void setUp() {
        ParseObject.registerSubclass(UBS.class);
        ubs = new UBS();
    }

    @Test
    public void test_getUbsLatitude() throws Exception {
        ubs.setUbsLatitude(3.23);
        assertEquals(valueOf(3.23), ubs.getUbsLatitude());
    }

    @Test
    public void test_getUbsLongitude() throws Exception {
        ubs.setUbsLongitude(2.11);
        assertEquals(valueOf(2.11), ubs.getUbsLongitude());
    }

    @Test
    public void test_getUbsName() throws Exception {
        ubs.setUbsName("test name");
        assertEquals("test name", ubs.getUbsName());
    }

    @Test
    public void test_getUbsAddress() throws Exception {
        ubs.setUbsAddress("test address");
        assertEquals("test address", ubs.getUbsAddress());
    }

    @Test
    public void test_getUbsNeighborhood() throws Exception {
        ubs.setUbsNeighborhood("test neighborhood");
        assertEquals("test neighborhood", ubs.getUbsNeighborhood());
    }

    @Test
    public void test_getUbsCity() throws Exception {
        ubs.setUbsCity("test city");
        assertEquals("test city", ubs.getUbsCity());
    }

    @Test
    public void test_getUbsAttentionLevel() throws Exception {
        ubs.setUbsAttentionLevel("test attention level");
        assertEquals("test attention level", ubs.getUbsAttentionLevel());
    }

    @Test
    public void test_toString() throws Exception {
        ubs.setUbsName("test toString");
        assertEquals("test toString", ubs.toString());
    }

    @Test
    public void test_getQuery() {
        assertNotEquals(ubs.getQuery(), ParseQuery.getQuery(UBS.class));
    }
}