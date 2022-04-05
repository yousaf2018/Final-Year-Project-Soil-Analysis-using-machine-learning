package com.example.meri_zameen;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class LanguageManager {
    private Context context;
    public  LanguageManager(Context context){
        this.context=context;
    }
    public void updateResourse(String code){
        Locale locale=new Locale(code);
        Locale.setDefault(locale);
        Resources resources=context.getResources();
        Configuration configuration=resources.getConfiguration();
        configuration.locale=locale;
        resources.updateConfiguration(configuration,resources.getDisplayMetrics());
    }

}
