package com.example.woofer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LogInActivity extends AppCompatActivity {

    private EditText userId, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //GUI for buttons, editTexts AND textviews
        userId = findViewById(R.id.userID);
        Password = findViewById(R.id.password);
        Button signInButton = findViewById(R.id.verifyButton);
        TextView signUpText = findViewById(R.id.SignUp);
        TextView forgotPasswordText = findViewById(R.id.ForgotPassword);

        //Takes in and checks username with u
        signInButton.setOnClickListener(v -> {
            String userId = userId.getText().toString().trim();
            String password = Password.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(LogInActivity.this, "Fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            OkHttpClient client = new OkHttpClient();

            RequestBody formBody = new FormBody.Builder()
                    .add("userId", username)
                    .add("password", password)
                    .build();

            Request request = new Request.Builder()
                    .url("https://lamp.ms.wits.ac.za/~s2610978/login.php")
                    .post(formBody)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    runOnUiThread(() -> Toast.makeText(LogInActivity.this, "Network Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        runOnUiThread(() -> Toast.makeText(LogInActivity.this, "Server Error", Toast.LENGTH_SHORT).show());
                        return;
                    }

                    String responseBody = response.body().string();
                    try {
                        JSONObject json = new JSONObject(responseBody);
                        boolean success = json.getBoolean("success");
                        String message = json.getString("message");

                        runOnUiThread(() -> {
                            Toast.makeText(LogInActivity.this, message, Toast.LENGTH_SHORT).show();
                            if (success) {
                                Intent intent = new Intent(LogInActivity.this, HomeScreenActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    } catch (JSONException e) {
                        runOnUiThread(() -> Toast.makeText(LogInActivity.this, "Invalid server response", Toast.LENGTH_SHORT).show());
                    }
                }
            });
        });

        //Pressing sign up taking you to signup page
        signUpText.setOnClickListener(v -> {
            Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        //Pressing forgot password taking you to email verification page
        forgotPasswordText.setOnClickListener(v -> {
            Intent intent = new Intent(LogInActivity.this, EmailVerificationActivity.class);
            startActivity(intent);
        });
    }
}
