package com.app.loginapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgotPasswordActivity extends AppCompatActivity {

    TextInputLayout email;
    Button reset;
    String emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        final FirebaseAuth auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.resetemail);
        reset = findViewById(R.id.resetpassword);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailAddress = email.getEditText().getText().toString();

                if (!isEmailValid(emailAddress)) {
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter valid email ", Toast.LENGTH_LONG).show();
                    return;
                } else {

                    Toast.makeText(ForgotPasswordActivity.this, "Reset Password Link has been sent to given registered email", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]+$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}







