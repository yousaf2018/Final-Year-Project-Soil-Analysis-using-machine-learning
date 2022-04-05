package com.example.meri_zameen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SensorDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_dashboard);
        getSupportActionBar().hide();
    }
}