package com.example.meri_zameen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {
    ImageButton btnImage, btnSensor;
    Button btnButton, eng, urdu, btnButton2;
    public static final String SHRED_PREF = "sharedPrefs";
    public static final String Save_Lang= "Lang";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        btnImage = findViewById(R.id.btnImageAnalysis);
        btnButton = findViewById(R.id.btnImageAnalysis2);
        btnButton2 = findViewById(R.id.btnSensorAnalysis2);
        btnSensor = findViewById(R.id.btnSensorAnalysis);
        eng = findViewById(R.id.english);
        urdu = findViewById(R.id.urdu);
        LanguageManager languageManager=new LanguageManager(this);
        //When user click on Urdu Button for Language Change
        urdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                languageManager.updateResourse("ur");
                SharedPreferences sharedPreferences = getSharedPreferences(SHRED_PREF,MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString(Save_Lang,"Urdu");
                editor.apply();
                recreate();
            }
        });
        //When user click on English Button for Language Change
        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                languageManager.updateResourse("en");
                SharedPreferences sharedPreferences = getSharedPreferences(SHRED_PREF,MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString(Save_Lang,"English");
                editor.apply();
                recreate();
            }
        });
        //When user clicks on image analysis
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, ImageAnalysis.class);
                startActivity(intent);
            }
        });
        //When user clicks on image analysis button
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, ImageAnalysis.class);
                startActivity(intent);
            }

        });
        //When user clicks on sensor analysis image
        btnSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Login.class);
                startActivity(intent);
            }
        });
        //When user clicks on sensor analysis button
        btnButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Login.class);
                startActivity(intent);
            }

        });

    }
}