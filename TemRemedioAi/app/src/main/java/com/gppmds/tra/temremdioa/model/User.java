package com.gppmds.tra.temremdioa.model;

import android.widget.EditText;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("User")
public class User extends ParseObject{
    private String password;
    private String name;
    private String genre;
    private String email;
    private int age;

    public User(String password, String name, String genre, String email, int age) {
        put(getTitlePassword(), password);
        put(getTitleName(), name);
        put(getTitleGenre(), genre);
        put(getTitleEmail(), email);
        put(getTitleAge(), age);
    }

    public String getPassword() {
        return getString(getTitlePassword());
    }

    public void setPassword(String password) {
        put(getTitlePassword(), password);
    }

    public String getName() {
        return getString(getTitleName());
    }

    public void setName(String name) {
        put(getTitleName(), name);
    }

    public String getGenre() {
        return getString(getTitleGenre());
    }

    public void setGenre(String genre) {
        put(getTitleGenre(), genre);
    }

    public String getEmail() {
        return getString(getTitleEmail());
    }

    public void setEmail(String email) {
        put(getTitleEmail(), email);
    }

    public int getAge() {
        return getInt(getTitleAge());
    }

    public void setAge(int age) {
        put(getTitleAge(), age);
    }

    public static ParseQuery<User> getQuery() {
        return ParseQuery.getQuery(User.class);
    }

    public static String getTitlePassword(){
        return "password_user";
    }
    public static String getTitleName(){
        return "name_user";
    }
    public static String getTitleGenre(){
        return "genre_user";
    }
    public static String getTitleEmail(){
        return "email_user";
    }
    public static String getTitleAge(){
        return "age_user";
    }

    public boolean isContainValid(String word, String contain) {
        return word.contains(contain);
    }

    public boolean isLengthValid(String word, int sizeMin, int sizeMax) {
        return word.length() > sizeMin && word.length() < sizeMax;
    }

    public boolean isPasswordValid(String password, String passwordConfirmation) {
        return passwordConfirmation.equals(password);
    }
}
