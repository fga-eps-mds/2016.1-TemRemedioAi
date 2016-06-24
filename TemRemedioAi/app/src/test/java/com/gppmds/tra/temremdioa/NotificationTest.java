package com.gppmds.tra.temremdioa;

import com.gppmds.tra.temremdioa.model.Notification;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class NotificationTest {

    private Notification notification;

    @Before
    public void setUp() {
        ParseObject.registerSubclass(Notification.class);
        notification = new Notification();
    }

    @Test
    public void getMedicineNameTest() throws Exception{
        notification.setMedicineName("Amoxicilina");
        assertEquals("Amoxicilina", notification.getMedicineName());
    }

    @Test
    public void getMedicineDosageTest() throws Exception{
        notification.setMedicineDosage("500 mg");
        assertEquals("500 mg", notification.getMedicineDosage());
    }

    @Test
    public void getUBSNameTest() throws Exception{
        notification.setUBSName("ADOLEScentro");
        assertEquals("ADOLEScentro", notification.getUBSName());
    }

    @Test
    public void getDateInformTest() throws Exception{
        Date dateTest = new Date();
        notification.setDateInform(dateTest);
        assertEquals(dateTest, notification.getDateInform());
    }

    @Test
    public void getAvailableTest() throws Exception{
        notification.setAvailable(true);
        assertEquals(true, notification.getAvailable());
    }

    @Test
    public void getUserInformTest() throws Exception{
        notification.setUserInform("John Doe");
        assertEquals("John Doe", notification.getUserInform());
    }

    @Test
    public void getQueryTest() throws Exception{
        assertNotEquals(notification.getQuery(), ParseQuery.getQuery(Notification.class));
    }

    @Test
    public void toStringTest() throws Exception {
        notification.setMedicineName("test toString");
        assertEquals("test toString", notification.toString());
    }
}
