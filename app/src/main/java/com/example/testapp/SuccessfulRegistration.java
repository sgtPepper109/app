package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SuccessfulRegistration extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_registration);

        Intent i2 = getIntent();
        String message = i2.getStringExtra(Screen2.message2);

        TextView viewSuccessText = findViewById(R.id.viewSuccessText);
        viewSuccessText.setText(message);


    }
}