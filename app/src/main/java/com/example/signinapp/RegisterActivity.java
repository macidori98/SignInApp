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

public class RegisterActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.signinapp.MESSAGE";

    EditText firstName, lastName, department;
    TextView sendingText, sigin, prof;
    String message;
    Button registerButton;
    Intent profileIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        firstName = findViewById(R.id.firstNameRegistration);
        lastName = findViewById(R.id.lastNameRegistration);
        department = findViewById(R.id.departmentRegistration);
        registerButton = findViewById(R.id.registrationButton);
        sendingText = findViewById(R.id.sendingText);
        sigin = findViewById(R.id.reg_num_reg);
        prof = findViewById(R.id.prof_num_reg);

        int count = MyCounterClass.getSignInPageToReg();
        sigin.setText(String.valueOf(count));
        count = MyCounterClass.getProfilePageToReg();
        prof.setText(String.valueOf(count));

        profileIntent = new Intent(this, ProfileActivityForResult.class);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCounterClass.setRegistrationPageToProf();
                message = firstName.getText().toString() + "\n\n" + lastName.getText().toString()
                        + "\n\n" + department.getText().toString();
                profileIntent.putExtra(EXTRA_MESSAGE,message);
                startActivityForResult(profileIntent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                sendingText.setText(firstName.getText().toString() + " " + lastName.getText().toString()
                        + " " + department.getText().toString());
                int count = MyCounterClass.getProfilePageToReg();
                prof.setText(String.valueOf(count));
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
