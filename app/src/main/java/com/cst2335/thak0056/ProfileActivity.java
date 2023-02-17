package com.cst2335.thak0056;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button but = findViewById(R.id.button);
        Button clear = findViewById(R.id.clear);
        TextView emailEditText = findViewById(R.id.emailpa);
        EditText name = findViewById(R.id.emailP);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        EditText address = findViewById(R.id.address);

        Intent fromMain = getIntent();
        emailEditText.setText(fromMain.getStringExtra("EMAIL"));

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String nam = name.getText().toString();
              String add = address.getText().toString();

              SharedPreferences shred = getSharedPreferences("data", MODE_PRIVATE);
              SharedPreferences.Editor editor = shred.edit();

              editor.putString("namee", nam);
              editor.putString("adrs", add);
              editor.apply();
            }
        });

        SharedPreferences getshared = getSharedPreferences("data", MODE_PRIVATE);
        String na = getshared.getString("namee","save name");
        String ad = getshared.getString("adrs","save address");

        name.setText(na);
        address.setText(ad);


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shred = getSharedPreferences("data", MODE_PRIVATE);
                SharedPreferences.Editor editor = shred.edit();
                address.setText(null);
                name.setText(null);
                editor.putString("namee", "");
                editor.putString("adrs", "");
                editor.apply();

            }
        });
    }}