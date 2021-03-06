package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginactivity extends AppCompatActivity {
    EditText Emailid,Password;
    Button LoginBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        Emailid = findViewById(R.id.editTextTextEmailAddress2);
        Password = findViewById(R.id.editTextTextPassword2);
        fAuth = FirebaseAuth.getInstance();
        LoginBtn = findViewById(R.id.button2);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String email = Emailid.getText ().toString().trim();
            String password = Password.getText().toString().trim();

            if (TextUtils.isEmpty (email)) {
                Emailid.setError("Email is Required.");
                return;
            }

            if (TextUtils.isEmpty (password)) {
                Password.setError("Password is Required.");
                return;
            }

            if (password. length() < 6) {
                Password.setError("Password Must be >= 6 Characters");
                return;
            }

            // authenticate the user
            fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(loginactivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                    }else {
                        Toast.makeText(loginactivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    }
                });
            }





    });
}}