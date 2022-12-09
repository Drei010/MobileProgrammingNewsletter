package com.example.finalgroupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class NewComment extends AppCompatActivity {
    EditText name, txtcomment;
    Button addCommentbtn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Hide Action Bar on load
        //Wag tangalin eto!
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_new_comment);



        name = findViewById(R.id.txtName);
        txtcomment = findViewById(R.id.txtComment);
        addCommentbtn = findViewById(R.id.addComment);
        addCommentbtn.setOnClickListener(v -> {
            String username = name.getText().toString()+"\n";
            String comment = txtcomment.getText().toString();
            DBHandler dbHandler = new DBHandler(NewComment.this);
            dbHandler.insertUserDetails(username,comment);
            intent = new Intent(NewComment.this,MainActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Details Inserted Successfully",Toast.LENGTH_SHORT).show();
        });






        //Opens Home page
        Button btnCall = findViewById(R.id.goHome);
        btnCall.setOnClickListener(v -> openHomePage());

    }
    public void openHomePage(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}