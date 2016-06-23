package com.gppmds.tra.temremdioa.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.widget.Toast;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.tra.gppmds.temremdioa.R;

public class SignUpActivity extends AppCompatActivity {

    ParseUser user = new ParseUser();

    /*Variaveis para o User*/
    private EditText mEmailView;
    private EditText mPasswordView;
    private EditText mPasswordViewConfirmation;
    private EditText mAgeView;
    private EditText mNameView;
    private EditText mUsernameView;
    private RadioButton mGenreMaleView;
    private RadioButton mGenreFemView;
    private TextView mGenre;
    private Button mRegisterButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setValues();

        setListener();

    }

    private void setValues() {

        mNameView = (EditText) findViewById(R.id.name);
        mEmailView = (EditText) findViewById(R.id.email);
        mAgeView = (EditText) findViewById(R.id.ageText);
        mPasswordView = (EditText) findViewById(R.id.password);
        mUsernameView = (EditText) findViewById(R.id.username);
        mPasswordViewConfirmation = (EditText) findViewById(R.id.password2);

        mGenre = (TextView) findViewById(R.id.textViewGenre);

        mGenreFemView = (RadioButton) findViewById(R.id.femButton);
        mGenreMaleView = (RadioButton) findViewById(R.id.mascButton);

        mRegisterButton = (Button) findViewById(R.id.register_button);
        cancelButton = (Button) findViewById(R.id.register_cancel);

    }

    private void setListener() {

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegister();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void attemptRegister() {

        // Reset errors.
        mNameView.setError(null);
        mEmailView.setError(null);
        mPasswordView.setError(null);
        mPasswordViewConfirmation.setError(null);
        mAgeView.setError(null);
        mGenreMaleView.setError(null);
        mGenreFemView.setError(null);
        mGenre.setError(null);
        mUsernameView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        String passwordConfirmation = mPasswordViewConfirmation.getText().toString();
        String name = mNameView.getText().toString();
        String username = mUsernameView.getText().toString();
        int age = 0;
        String genre = null;

        boolean cancel = false;
        View focusView = null;

        /*Password*/
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            cancel = true;
        }
        else if (password.length() < 6){
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }
        else if (!password.equals(passwordConfirmation)) {
            mPasswordViewConfirmation.setError(getString(R.string.error_different_password));
            focusView = mPasswordViewConfirmation;
            cancel = true;
        }

        /*Email*/
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isContainValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        /*Name*/
        if (TextUtils.isEmpty(name)) {
            mNameView.setError(getString(R.string.error_field_required));
            focusView = mNameView;
            cancel = true;
        } else if (getSpecialCharacter(name)) {
            mNameView.setError(getString(R.string.error_character));
            focusView = mNameView;
            cancel = true;
        }

        /*Age*/
        if (TextUtils.isEmpty(mAgeView.getText().toString())) {
            mAgeView.setError(getString(R.string.error_field_required));
            focusView = mAgeView;
            cancel = true;
        } else {
            age = Integer.parseInt(mAgeView.getText().toString());
            if (age < 0 || age > 100) {
                mAgeView.setError(getString(R.string.error_invalid_age));
            }
        }

        /*Genre*/
        if (!mGenreMaleView.isChecked() && !mGenreFemView.isChecked()) {
            mGenre.setError(getString(R.string.error_invalid_genre));
            focusView = mGenre;
            cancel = true;
        }
        else if (mGenreFemView.isChecked()) genre = "Feminino";
        else if (mGenreMaleView.isChecked()) genre = "Masculino";

        /*Username*/
        if (TextUtils.isEmpty(username)) {
            mUsernameView.setError(getString(R.string.error_field_required));
            focusView = mUsernameView;
            cancel = true;
        }

        if (cancel) {

            focusView.requestFocus();

        } else {

            user.setEmail(email);
            user.setPassword(password);
            user.setUsername(username);
            user.put("Name", name);
            user.put("Age" , age);
            user.put("Genre" , genre);
            user.signUpInBackground ( new SignUpCallback() {
                @Override
                public void done(com.parse.ParseException e) {
                    if (e == null ) {
                        Toast.makeText(getApplicationContext(), "Cadastrado efetuado com sucesso", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Erro no cadastro, tente novamente!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            finish();
        }
    }

    public boolean getSpecialCharacter(String word) {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(word);
        return matcher.find();
    }

    public boolean isContainValid(String email) {
        return email.contains("@");
    }
}