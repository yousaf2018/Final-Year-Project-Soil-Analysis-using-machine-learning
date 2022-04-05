package com.example.meri_zameen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    private static final String TAG = "Check";
    EditText emailAddress, password, conformPassword;
    TextView textSinup;
    Button btnSignup;
    ProgressBar progressBar;
    public static final String SHRED_PREF = "sharedPrefs";
    public static final String Save_Email = "email";
    public static final String Save_Lang= "Lang";
    String lang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        emailAddress  = (EditText) findViewById(R.id.emailAddress);
        password = (EditText) findViewById(R.id.password);
        conformPassword = (EditText) findViewById(R.id.conformPassword);
        textSinup = (TextView) findViewById(R.id.textSinup);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        progressBar = findViewById(R.id.progressbar2);
        progressBar.setVisibility(View.GONE);
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        SharedPreferences pref = getApplicationContext().getSharedPreferences(SHRED_PREF, getApplicationContext().MODE_PRIVATE);
        lang = pref.getString(Save_Lang, "Lang");
        // setLanguage(lang);
        LanguageManager languageManager=new LanguageManager(this);
        if (lang.equals("Urdu")){
            languageManager.updateResourse("ur");
            // recreate();
        }
        else {
            languageManager.updateResourse("en");
            // recreate();
        }
        //When user clicks on SignUp Button
        btnSignup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email = emailAddress.getText().toString();
                String passwd = password.getText().toString();
                String conformPasswd = conformPassword.getText().toString();
                if(email.isEmpty() || passwd.isEmpty() || conformPasswd.isEmpty()) {
                    // If name or password is not entered
                    Toast.makeText(getApplicationContext(), "Both Name and Password are required", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
                else if(!passwd.equals(conformPasswd)){
                    Toast.makeText(getApplicationContext(), "Passwords are not match", Toast.LENGTH_LONG).show();
                    Log.i(TAG,"Invalid-->"+email+" --->"+passwd+"    "+conformPasswd);
                    progressBar.setVisibility(View.GONE);

                }
                else {
                    FirebaseAuth firebaseAuth;
                    firebaseAuth = FirebaseAuth.getInstance();
                    firebaseAuth.createUserWithEmailAndPassword(email,passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Your email is successfully authenticated",Toast.LENGTH_LONG).show();
                                saveData(emailAddress);
                                progressBar.setVisibility(View.GONE);
                                startActivity(new Intent(getApplicationContext(), SensorDashboard.class));
                            }
                        }

                        private void saveData(EditText emailAddress) {
                            SharedPreferences sharedPreferences = getSharedPreferences(SHRED_PREF,MODE_PRIVATE);
                            SharedPreferences.Editor editor= sharedPreferences.edit();
                            Toast.makeText(getApplicationContext(),""+emailAddress.getText().toString(),Toast.LENGTH_LONG).show();
                            editor.putString(Save_Email,emailAddress.getText().toString());
                            editor.apply();
                        }
                    });

                }
            }
        });
        //When user click on Login Text
        textSinup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));

            }
        });

    }
}