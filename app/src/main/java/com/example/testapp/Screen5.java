package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class Screen5 extends AppCompatActivity {
    public static int counter2 = 1;

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen5);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Intent i = getIntent();
        String counter = i.getStringExtra(MainActivity.message);

        TextView headerScreen5 = findViewById(R.id.headerScreen5);
        headerScreen5.setText("0 clicks");
        ConstraintLayout cl = (ConstraintLayout) findViewById(R.id.screen5);

        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headerScreen5.setText(counter2 + " clicks");
                Bundle params = new Bundle();
                params.putString(FirebaseAnalytics.Param.ITEM_CATEGORY5, "SCREEN CLICKED");
                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, params);
                counter2 ++;
            }
        });
    }
}