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

public class SignUpActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button btnregister;
    TextInputEditText regEmail, regPassword;
    TextView loginHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth=FirebaseAuth.getInstance();
        regEmail=findViewById(R.id.regemail);
        regPassword=findViewById(R.id.regpassword);
        loginHere=findViewById(R.id.loginhere);
        btnregister=findViewById(R.id.btnregister);


        btnregister.setOnClickListener(view ->{
            createUser();
        });

        loginHere.setOnClickListener(view->{
            startActivity(new Intent(SignUpActivity.this,LoginActivity.class));

        });
    }
    private void createUser(){
        String email=regEmail.getText().toString();
        String password=regPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            regEmail.setError("email required");
            regEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            regPassword.setError("password required");
            regPassword.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if (task.isSuccessful()){
                       Toast.makeText(SignUpActivity.this,"user created successfully",Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                   }else {
                       Toast.makeText(SignUpActivity.this,"user creation failed"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                   }
                }
            });
        }

    }
}