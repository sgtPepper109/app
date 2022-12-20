package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    public static int counter = 0;
    public static final String message = "com.example.test.message";

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        TextView headerMain = findViewById(R.id.headerMain);
        headerMain.setText(counter + " clicks");
        counter += 1;
        ConstraintLayout cl = (ConstraintLayout) findViewById(R.id.mainActivityScreen);
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headerMain.setText(counter + " clicks");
                counter ++;
            }
        });
    }

    public void jumpScreen2(View view) {
        // function to jump to screen 2 (form)
        Intent i = new Intent(this, com.example.testapp.Screen2.class);
        String msg = "You are on Screen 2 (Form)";
        i.putExtra(message, msg);
        startActivity(i);
    }

    public void jumpScreen3(View view) {
        // function to jump to screen 3 (horizontal slider)
        Intent i = new Intent(this, com.example.testapp.Screen3.class);
        String msg2 = "\n\nYou are on Screen 3 (Horizontal Slider)\n Slide to view images";
        i.putExtra(message, msg2);
        startActivity(i);
    }

    public void jumpScreen4(View view) {
//        Intent i = new Intent(this, Screen4.class);
//        String msg2 = "You are on screen 4 (search)";
//        i.putExtra(message, msg2);
//        startActivity(i);
    }

    public void jumpScreen5(View view) {
        // function to jump to screen 5 (counter)
        Intent i = new Intent(this, com.example.testapp.Screen5.class);
        String msg = "" + counter + "";
        i.putExtra(message, msg);
        startActivity(i);
    }
}