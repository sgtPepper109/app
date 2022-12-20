package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class Screen2 extends AppCompatActivity {
    public static final String message2 = "com.example.test.message2";

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Intent i = getIntent();
        String message = i.getStringExtra(MainActivity.message);

        // Set text inside textview to message
        TextView headerTextView = findViewById(R.id.headerTextView);
        headerTextView.setText(message);

    }

    public void showSuccessfulRegistration(View view) {
        // This is for navigation to page showing successful registration of user

        Bundle params = new Bundle();

        Intent i2 = new Intent(this, SuccessfulRegistration.class);
        EditText editName = findViewById(R.id.editName);
        EditText editEmail = findViewById(R.id.editEmail);
        EditText editPhone = findViewById(R.id.editPhone);
        String msg2 = "You are successfully registered as a user.\nCheck your details"
                + "\nName: " + editName.getText().toString()
                + "\nE-Mail: " + editEmail.getText().toString()
                + "\nPhone: " + editPhone.getText().toString();
        i2.putExtra(message2, msg2);

        params.putString(FirebaseAnalytics.Param.ITEM_NAME, editName.getText().toString());
        params.putString(FirebaseAnalytics.Param.ITEM_CATEGORY2, editEmail.getText().toString());
        params.putString(FirebaseAnalytics.Param.ITEM_CATEGORY3, editPhone.getText().toString());
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, params);


        startActivity(i2);
    }
}