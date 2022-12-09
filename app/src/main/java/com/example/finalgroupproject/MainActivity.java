package com.example.finalgroupproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide Action Bar on load
        //Wag tangalin eto!
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_main);

        //Database handler
        DBHandler db = new DBHandler(this);
        ArrayList<HashMap<String, String>> userList = db.GetUsers();
        ListView lv = findViewById(R.id.user_list);
        ListAdapter adapter = new SimpleAdapter(MainActivity.this,
                userList, R.layout.list_row,new String[]{"name","comment"},
                new int[]{R.id.name, R.id.comment});
        lv.setAdapter(adapter);

        //Comment scroll
        lv.setOnTouchListener((v, event) -> {
            int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    // Disallow ScrollView to intercept touch events.
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    break;

                case MotionEvent.ACTION_UP:
                    // Allow ScrollView to intercept touch events.
                    v.getParent().requestDisallowInterceptTouchEvent(false);
                    break;
            }

            // Handle ListView touch events.
            v.onTouchEvent(event);
            return true;
        });

        //Opens comments page
        Button btnCall = findViewById(R.id.newPage);
        btnCall.setOnClickListener(v -> openCommentsPage());

    }
    public void openCommentsPage(){
        Intent i = new Intent(this, NewComment.class);
          startActivity(i);
    }
}