package com.example.nyumba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddActivity extends AppCompatActivity {
    Button add,back;
    EditText name,location,rent,image,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        add=(Button) findViewById(R.id.btnadd);
        back=(Button) findViewById(R.id.btnback);
        name=(EditText) findViewById(R.id.name);
        location=(EditText) findViewById(R.id.location);
        rent=(EditText) findViewById(R.id.rent);
        image=(EditText) findViewById(R.id.image);
        contact=(EditText) findViewById(R.id.contact);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
addData();
clearAll();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void addData(){

        Map<String,Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("location",location.getText().toString());
        map.put("rent",rent.getText().toString());
        map.put("contact",contact.getText().toString());
        map.put("image",image.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("categories/Komarock1").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this, "Record added successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddActivity.this, "Failed to add a new listing", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void clearAll(){

        name.setText("");
        location.setText("");
        rent.setText("");
        contact.setText("");
        image.setText("");
    }
}