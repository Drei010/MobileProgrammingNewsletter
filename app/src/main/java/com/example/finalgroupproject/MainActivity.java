package com.example.finalgroupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide Action Bar on load
        //Wag tangalin eto!
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        //Database handler
        DBHandler db = new DBHandler(this);
        ArrayList<HashMap<String, String>> userList = db.GetUsers();
        ListView lv = (ListView) findViewById(R.id.user_list);
        ListAdapter adapter = new SimpleAdapter(MainActivity.this,
                userList, R.layout.list_row,new String[]{"name","comment"},
                new int[]{R.id.name, R.id.comment});
        lv.setAdapter(adapter);



        //Opens comments page
        Button btnCall = (Button)findViewById(R.id.newPage);
        btnCall.setOnClickListener(v -> openCommentsPage());

    }
    public void openCommentsPage(){
        Intent i = new Intent(this, NewComment.class);
          startActivity(i);
    }
}