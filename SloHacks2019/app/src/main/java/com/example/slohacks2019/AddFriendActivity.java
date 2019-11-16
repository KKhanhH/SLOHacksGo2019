package com.example.slohacks2019;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputLayout;

public class AddFriendActivity extends Activity {

    private TextInputLayout friendField;
    private TextInputLayout friendNumber;
    private TextInputLayout interestingFact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected User newFriend() {
        friendField = findViewById(R.id.friend_field);
        friendNumber = findViewById(R.id.friend_number);
        interestingFact = findViewById((R.id.interesting_fact));



    }

}
