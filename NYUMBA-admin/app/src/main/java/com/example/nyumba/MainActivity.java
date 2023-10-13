package com.example.nyumba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button button1, button2,button3,button4;
    FirebaseAuth mAuth;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.komarock1);
        button2 = (Button) findViewById(R.id.komarock2);
        button3 = (Button) findViewById(R.id.komarock3);
        mAuth=FirebaseAuth.getInstance();
        button4 = (Button) findViewById(R.id.komarock4);
        floatingActionButton=(FloatingActionButton) findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddActivity.class));
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoc1Activity();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoc2Activity();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoc3Activity();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoc4Activity();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=mAuth.getCurrentUser();
        if (user==null){
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }
    }

    public void openLoc1Activity() {
        Intent intent = new Intent(this, Location1Activity.class);
        startActivity(intent);
    }

    public void openLoc2Activity() {
        Intent intent = new Intent(this, Location2Activity.class);
        startActivity(intent);
    }

    public void openLoc3Activity() {
        Intent intent = new Intent(this, Location3Activity.class);
        startActivity(intent);
    }

    public void openLoc4Activity() {
        Intent intent = new Intent(this, Location4Activity.class);
        startActivity(intent);
    }
}