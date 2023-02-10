package com.cst2335.thak0056;

import static android.provider.ContactsContract.Intents.Insert.EMAIL;
import static java.lang.System.in;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

     Button log = findViewById(R.id.login);
     TextView tex = findViewById(R.id.email);
     log.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent goToProfile = new Intent(MainActivity.this, ProfileActivity.class);
             goToProfile.putExtra("EMAIL",tex.getText().toString());
             startActivity(goToProfile);
         }
     });
    }}
