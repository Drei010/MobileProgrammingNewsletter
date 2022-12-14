package com.example.finalgroupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class AboutPage extends AppCompatActivity {
    EditText inputTxt;
    Button sendBtn, viewBtn;
    TextView displayTxt;
       @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

           //Hide Action Bar on load
           //Wag tangalin eto!
           requestWindowFeature(Window.FEATURE_NO_TITLE);
           this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
           Objects.requireNonNull(getSupportActionBar()).hide();
           setContentView(R.layout.activity_about_page);

    //Read and write
           inputTxt = findViewById(R.id.inputTxt);
           sendBtn = findViewById(R.id.sendBtn);
           viewBtn = findViewById(R.id.viewBtn);
           displayTxt = findViewById(R.id.displayTxt);

           sendBtn.setOnClickListener((v)-> writeFile());
           viewBtn.setOnClickListener((v)-> readFile());





            //Opens Home page
           Button btnCall = findViewById(R.id.seeAll);
           btnCall.setOnClickListener(v -> openHomePage());

        }

        public void openHomePage() {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }



    public void writeFile(){
        String textToSave = inputTxt.getText().toString();
        try{
            FileOutputStream fileOutputStream = openFileOutput("SampleFile.txt", MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream.close();

            Toast.makeText(getApplicationContext(),"Thank you for your feedback", Toast.LENGTH_LONG).show();
            inputTxt.setText("");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readFile(){
        try{
            FileInputStream fileInputStream = openFileInput("SampleFile.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuffer = new StringBuilder();

            String Lines;
            while((Lines = bufferedReader.readLine())!= null){
                stringBuffer.append(Lines).append("\n");
            }

            displayTxt.setText(stringBuffer.toString());
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    }