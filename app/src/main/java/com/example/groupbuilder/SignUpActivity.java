package com.example.groupbuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private EditText emailTV, passwordTV;
    private Button registerButton;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        initializeUI();

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                registerNewUser();
            }
        });
    }

private void registerNewUser() {
    progressBar.setVisibility(View.VISIBLE);
    String email, password;
    email = emailTV.getText().toString();
    password = passwordTV.getText().toString();

    if (TextUtils.isEmpty(email)) {
        Toast.makeText(getApplicationContext(), "Please enter an email", Toast.LENGTH_LONG).show();
        return;
    }
    if (TextUtils.isEmpty(password)) {
        Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_LONG).show();
        return;
    }

    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                Toast.makeText(getApplicationContext(), "Sign up complete", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Sign up failed, please try again", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        }
    });
}

private void initializeUI(){
    emailTV = findViewById(R.id.email);
    passwordTV = findViewById(R.id.password);
    registerButton = findViewById(R.id.register);
    progressBar = findViewById(R.id.progressBar);
}

}
