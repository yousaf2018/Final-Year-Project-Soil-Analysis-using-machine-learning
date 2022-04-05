package com.example.meri_zameen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class ReportGeneration extends AppCompatActivity {
    public static final String SHRED_PREF = "sharedPrefs";
    public static final String Save_P= "P";
    public static final String Save_pH = "pH";
    public static final String Save_OM = "OM";
    public static final String Save_Lang= "Lang";
    public static final String Save_EC = "EC";
    String P, pH, OM, EC, lang;
    TextView ecTab, phTab, omTab, pTab;
    Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        getSupportActionBar().hide();
        SharedPreferences pref = getApplicationContext().getSharedPreferences(SHRED_PREF, getApplicationContext().MODE_PRIVATE);
        P = pref.getString(Save_P, "P");
        pH = pref.getString(Save_pH, "pH");
        OM = pref.getString(Save_OM, "OM");
        EC = pref.getString(Save_EC, "EC");
        lang = pref.getString(Save_Lang, "Lang");
        setLanguage(lang);
        ecTab = findViewById(R.id.ecTab);
        omTab = findViewById(R.id.omTab);
        phTab = findViewById(R.id.phTab);
        pTab = findViewById(R.id.pTab);
        home = findViewById(R.id.Home);
        assignValues(EC, P, OM, pH);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReportGeneration.this, ImageAnalysis.class);
                startActivity(intent);
            }
        });
    }


    private void setLanguage(String lang) {
        LanguageManager languageManager=new LanguageManager(this);
        if (lang.equals("Urdu")){
            languageManager.updateResourse("ur");
           // recreate();
        }
        else {
            languageManager.updateResourse("en");
            // recreate();
        }
    }

    private void assignValues(String ec, String p, String om, String pH) {
        assignPHValues(pH);
        assignECValues(EC);
        assignOMValues(OM);
        assignPValues(P);
    }

    private void assignPValues(String p) {
        // convert into Double
        double pValue = Double.parseDouble(p);
        if (pValue < 3.5){
            pTab.setText(getResources().getString(R.string.p_3_5));
        }
        else if (pValue > 3.6 && pValue < 7.0){
            pTab.setText(getResources().getString(R.string.p_3_6_7));

        }
        else if (pValue > 7.1 && pValue < 14.0){
            pTab.setText(getResources().getString(R.string.p_7_1_14));
        }
        else{
            pTab.setText(getResources().getString(R.string.p_14));

        }
    }

    private void assignOMValues(String om) {
        // convert into Double
        double omValue = Double.parseDouble(om);
        if (omValue < 0.86){
            omTab.setText(getResources().getString(R.string.om_0_86));
        }
        else if (omValue > 0.87 && omValue < 1.29){
            omTab.setText(getResources().getString(R.string.om_0_87_1_29));

        }
        else{
            omTab.setText(getResources().getString(R.string.om_1_29));

        }
    }

    private void assignECValues(String ec) {
        // convert into Double
        double ecValue = Double.parseDouble(ec);
        if (ecValue < 4.0){
            ecTab.setText(getResources().getString(R.string.ec_4));
        }
        else if (ecValue > 4.1 && ecValue < 8.0){
            ecTab.setText(getResources().getString(R.string.ec_4_1_8));

        }
        else if (ecValue > 8.1 && ecValue < 16.0){
            ecTab.setText(getResources().getString(R.string.ec_8_1_16));
        }
        else{
            ecTab.setText(getResources().getString(R.string.ec_16));

        }

    }

    private void assignPHValues(String pH) {
        // convert into Double
        double phValue = Double.parseDouble(pH);
        if (phValue > 7.0 && phValue < 7.5){
            phTab.setText(getResources().getString(R.string.ph_7_to_7_5));
        }
        else if (phValue > 7.5 && phValue < 8.0){
            phTab.setText(getResources().getString(R.string.ph_7_6_to_8));
        }
        else if (phValue > 8.0 && phValue < 8.5){
            phTab.setText(getResources().getString(R.string.ph_8_1_to_8_5));
        }
        else{
            phTab.setText(getResources().getString(R.string.ph_8_6));

        }
    }
}