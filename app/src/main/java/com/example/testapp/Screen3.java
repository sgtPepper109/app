package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class Screen3 extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle params = new Bundle();

        Intent i = getIntent();
        String message = i.getStringExtra(MainActivity.message);

        TextView headerScreen3 = findViewById(R.id.headerScreen3);
        headerScreen3.setText(message);

        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontalScrollView);
        horizontalScrollView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                params.putString(FirebaseAnalytics.Param.ITEM_CATEGORY5, "SLIDER CLICKED");
                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, params);
            }
        });
    }
}