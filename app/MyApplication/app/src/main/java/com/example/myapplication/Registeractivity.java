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


public class Registeractivity extends AppCompatActivity {
    EditText FullName, Emailid, Password, Mobilenumber;
    Button RegisterBtn;
    TextView LoginBtn;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);

        FullName = findViewById(R.id.editTextTextPersonName);
        Emailid = findViewById(R.id.editTextTextEmailAddress);
        Password = findViewById(R.id.editTextTextPassword);
        Mobilenumber = findViewById(R.id.editTextPhone2);
        RegisterBtn = findViewById(R.id.registerButton);
        LoginBtn = findViewById(R.id.textView4);


        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Emailid.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Emailid.setError("Email is Required.");
                    return;

                }

                if (TextUtils.isEmpty(password)) {
                    Password.setError("Password is Required.");
                    return;
                }

                if (password.length() < 6) {
                    Password.setError("Password Must be >= 6 Characters");
                    return;
                }

                // register the user in firebase

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Registeractivity.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity2.class));

                        } else {
                            Toast.makeText(Registeractivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }}