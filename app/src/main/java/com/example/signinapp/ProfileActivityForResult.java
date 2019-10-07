package com.example.signinapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivityForResult extends AppCompatActivity {
    TextView details, reg, sigin;
    Intent previousIntent;
    String fname, lname, dep, message;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        details = findViewById(R.id.about);
        reg = findViewById(R.id.reg_num_prof);
        sigin = findViewById(R.id.prof_num_prof);
        int count = MyCounterClass.getRegistrationPageToProf();
        reg.setText(String.valueOf(count));
        count = MyCounterClass.getSignInPageToProf();
        sigin.setText(String.valueOf(count));

        previousIntent = getIntent();
        //message = previousIntent.getStringExtra(SigningInActivity.EXTRA_MESSAGE);
        fname = previousIntent.getStringExtra("ffirstname");
        lname = previousIntent.getStringExtra("llastname");
        dep = previousIntent.getStringExtra("ddepartment");
        message = fname + "\n\n" + lname + "\n\n" + dep;
        details.setText(message);

    }

    public void onBack(View view){
        MyCounterClass.setProfilePageToReg();
        previousIntent = new Intent();
        setResult(Activity.RESULT_OK,previousIntent);
        finish();
    }
}
