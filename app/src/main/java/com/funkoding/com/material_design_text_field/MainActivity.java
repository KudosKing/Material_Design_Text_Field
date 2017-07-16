package com.funkoding.com.material_design_text_field;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class MainActivity extends AppCompatActivity {

    Toast t;
    AppCompatEditText userName;
    AppCompatEditText password;
    AppCompatEditText email;
    TextInputLayout userLayout;
    TextInputLayout passLayout;
    TextInputLayout emailLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (AppCompatEditText) findViewById(R.id.username);
        password = (AppCompatEditText) findViewById(R.id.password);
        email = (AppCompatEditText) findViewById(R.id.email);

        userName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                toastMessage("Username Field");

            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                toastMessage("Password Field");

            }
        });

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                toastMessage("Email Field");

            }
        });

        userLayout = (TextInputLayout) findViewById(R.id.username_TextInputlayout);
        passLayout = (TextInputLayout) findViewById(R.id.password_TextInputlayout);
        emailLayout = (TextInputLayout) findViewById(R.id.email_TextInputlayout);

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (userName.getText().toString().isEmpty()) {
                    userLayout.setErrorEnabled(true);
                    userLayout.setError("Username Required");
                } else {
                    userLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (password.getText().toString().isEmpty()) {
                    passLayout.setErrorEnabled(true);
                    passLayout.setError("Password Required");
                } else {
                    passLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        passLayout.setCounterEnabled(true);
        passLayout.setCounterMaxLength(10);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (email.getText().toString().isEmpty()) {
                    emailLayout.setErrorEnabled(true);
                    emailLayout.setError("Email Required");
                } else if (!email.getText().toString().isEmpty()) {

                    try {
                        InternetAddress emailAddr = new InternetAddress(email.getText().toString());
                        emailAddr.validate();
                        emailLayout.setErrorEnabled(false);
                    } catch (AddressException e) {
                        emailLayout.setErrorEnabled(true);
                        emailLayout.setError(e.getMessage());
                    }

                } else {
                    emailLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void toastMessage(String text) {
        if (t == null) {
            t = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        } else {
            t.setText(text);
        }
        t.show();

    }


}
