//This file will transfer all the inputs into the EmailVerification activity.

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    EditText emailInput, usernameInput, passwordInput, nameInput;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // GUI Elements
        nameInput = findViewById(R.id.fullName);
        usernameInput = findViewById(R.id.userID);
        emailInput = findViewById(R.id.email);
        passwordInput = findViewById(R.id.password);
        signUpButton = findViewById(R.id.signUpButton);



        // Button to SIGN UP
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String userId = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                String name = nameInput.getText().toString();
                // Validation
                if (!isValidName(name)) {
                    nameInput.setError("Name at least 2 letters, only letters and spaces)");
                    return;
                }

                if (!isValidUsername(userId)) {
                    usernameInput.setError("UserID must be 5-20 characters (letters or numbers)");
                    return;
                }

                if (!isValidEmail(email)) {
                    emailInput.setError("Invalid email address");
                    return;
                }

                if (!isValidPassword(password)) {
                    passwordInput.setError("Password must be 8+ characters and include uppercase, lowercase, number, and a special character");
                    return;
                }


                Intent intent = new Intent(SignUpActivity.this, EmailVerificationActivity.class);

                Toast.makeText(SignUpActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                intent.putExtra("email", email);
                intent.putExtra("name", name);
                intent.putExtra("userID", userId);
                intent.putExtra("password", password);

                startActivity(intent);
            }
        });

    }

    //Methods for validation
    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public boolean isValidUsername(String username) {
        return username != null && username.matches("^[a-zA-Z0-9]{5,20}$");
    }

    public boolean isValidPassword(String password) {
        return password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }

    public boolean isValidName(String name) {
        return name != null && name.matches("^[A-Za-z ]{2,}$");
    }
}

