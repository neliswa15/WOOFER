package com.example.woofer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    EditText emailInput, usernameInput, passwordInput;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // GUI Elements
        emailInput = findViewById(R.id.userId);
        usernameInput = findViewById(R.id.userName);
        passwordInput = findViewById(R.id.password);
        signUpButton = findViewById(R.id.signUpButton);



        // Button to SIGN UP
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                Intent intent = new Intent(SignUpActivity.this, EmailVerificationActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });

    }
}

