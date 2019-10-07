package com.example.signinapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SigningInActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.signinapp.MESSAGE";

    EditText firstName, lastName;
    Button signUp, register;
    String intentMessage;
    Intent profileIntent, registerIntent;
    TextView reg, prof;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);

        signUp = findViewById(R.id.sign_up);
        register = findViewById(R.id.register);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        reg = findViewById(R.id.reg_num_signin);
        prof = findViewById(R.id.prof_num_signin);
        int count = MyCounterClass.getRegistrationPageToSigin();
        reg.setText(String.valueOf(count));
        count = MyCounterClass.getProfilePageToSigin();
        prof.setText(String.valueOf(count));


        profileIntent = new Intent(this, ProfileActivity.class);
        registerIntent = new Intent(this, RegisterActivity.class);



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileIntent.putExtra("fname", firstName.getText().toString());
                profileIntent.putExtra("lname", lastName.getText().toString());
                /*intentMessage = firstName.getText().toString() + "\n\n" + lastName.getText().toString()
                 + "\n\n" + "-";
                profileIntent.putExtra(EXTRA_MESSAGE, intentMessage);*/
                MyCounterClass.setSignInPageToProf();
                startActivity(profileIntent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCounterClass.setSignInPageToReg();
                startActivity(registerIntent);
            }
        });
    }
}
