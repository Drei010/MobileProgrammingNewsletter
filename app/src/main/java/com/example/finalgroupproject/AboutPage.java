package com.example.finalgroupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Objects;

public class AboutPage extends AppCompatActivity {

       @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //Hide Action Bar on load
            //Wag tangalin eto!
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            Objects.requireNonNull(getSupportActionBar()).hide();

            setContentView(R.layout.activity_about_page);

            //Opens Home page
            Button btnCall = findViewById(R.id.seeAll);
            btnCall.setOnClickListener(v -> openHomePage());

        }

        public void openHomePage() {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }