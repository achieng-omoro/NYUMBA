package com.example.nyumba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText loginEmail, loginPassword;
    Button btnlogin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEmail=findViewById(R.id.loginemail);
        loginPassword=findViewById(R.id.loginpassword);
        btnlogin=findViewById(R.id.btnlogin);
        mAuth=FirebaseAuth.getInstance();

        btnlogin.setOnClickListener(view->{

            loginUser();
        });
    }

    private void loginUser(){

        String email=loginEmail.getText().toString();
        String password=loginPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            loginEmail.setError("email required");
            loginEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            loginPassword.setError("password required");
            loginPassword.requestFocus();
        }else {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"user login successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    }else {
                        Toast.makeText(LoginActivity.this,"user login failed"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


    }
}