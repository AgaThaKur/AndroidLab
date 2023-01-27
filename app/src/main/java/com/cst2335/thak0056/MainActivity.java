package com.cst2335.thak0056;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

private Button button;
private Switch sw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button2);
        sw=findViewById(R.id.switch1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,  getResources().getString(R.string.toast_message) , Toast.LENGTH_LONG).show();
            };
        });
     boolean originalState = sw.isChecked();
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String message = "The switch is now " + (isChecked ? "on" : "off");
                Snackbar snackbar = Snackbar.make(buttonView, message, Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sw.setChecked(originalState);
                            }
                        });
                snackbar.show();
            }
        } );
        }}
