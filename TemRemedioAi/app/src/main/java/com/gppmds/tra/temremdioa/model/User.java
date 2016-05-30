package com.gppmds.tra.temremdioa.model;

import android.widget.EditText;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

@ParseClassName("User")
public class User extends ParseUser{
    private String passwordTxt;
    private String nameTxt;
    private String genreTxt;
    private String emailTxt;
    private int ageTxt;

    public User(String passwordTxt, String nameTxt, String genreTxt, String emailTxt, int ageTxt) {
        this.passwordTxt = passwordTxt;
        this.nameTxt = nameTxt;
        this.genreTxt = genreTxt;
        this.emailTxt = emailTxt;
        this.ageTxt = ageTxt;
    }

    public void setPasswordTxt(String passwordTxt) {
        setPassword(passwordTxt);
    }

    public void setNameTxt(String nameTxt) {
        put(getTitleName(), nameTxt);
    }

    public void setGenreTxt(String genreTxt) {
        put(getTitleGenre(), genreTxt);
    }

    public void setEmailTxt(String emailTxt) {
        setEmail(emailTxt);
    }

    public void setAgeTxt(int ageTxt) {
        put(getTitleAge(), ageTxt);
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
