package com.example.signinapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView details, reg, sigin;
    Intent previousIntent;
    String message, fname, lname;
    Button back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        details = findViewById(R.id.about);
        back = findViewById(R.id.buttonBack);
        reg = findViewById(R.id.reg_num_prof);
        sigin = findViewById(R.id.prof_num_prof);

        int count = MyCounterClass.getRegistrationPageToProf();
        reg.setText(String.valueOf(count));
        count = MyCounterClass.getSignInPageToProf();
        sigin.setText(String.valueOf(count));

        previousIntent = getIntent();
        fname = previousIntent.getStringExtra("fname");
        lname = previousIntent.getStringExtra("lname");
        message = fname + "\n\n" + lname;

        details.setText(message);

    }

    public void onBack(View view){
        MyCounterClass.setProfilePageToSigin();
        finish();
    }
}
