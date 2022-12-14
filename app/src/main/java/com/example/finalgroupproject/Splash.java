package com.example.finalgroupproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide Action Bar on load
        //Wag tangalin eto!
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();


        // on below line we are configuring our window to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        // on below line we are calling handler to run a task
        // for specific time interval
        new Handler().postDelayed(() -> {
            // on below line we are
            // creating a new intent
            Intent i = new Intent(Splash.this, MainActivity.class);

            // on below line we are
            // starting a new activity.
            startActivity(i);

            // on the below line we are finishing
            // our current activity.
            finish();
        }, 2000);

    }
}

