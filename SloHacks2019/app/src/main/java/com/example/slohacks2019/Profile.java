package com.example.slohacks2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class Profile extends AppCompatActivity {

    private TextInputEditText myName;
    private TextInputEditText myNumber;
    private TextInputEditText myInterestingFact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        myName = findViewById(R.id.name);
        myNumber = findViewById(R.id.phone);
        myInterestingFact = findViewById((R.id.funFact));
        if(StoredInfo.getCurrentUser().getIdentifier()!="Dummy"){
            myName.setText(StoredInfo.getCurrentUser().getName());
            myNumber.setText(StoredInfo.getCurrentUser().getIdentifier());
            myInterestingFact.setText(StoredInfo.getCurrentUser().getFact());

        }
    }

    public void saveProfile(View view){ myName = findViewById(R.id.name);
        String name = myName.getText().toString();
        String number = myNumber.getText().toString();
        String fact = myInterestingFact.getText().toString();

        User currentUser = new User(name,number,fact);
        StoredInfo.updateCurrentUser(currentUser);


    }
}
