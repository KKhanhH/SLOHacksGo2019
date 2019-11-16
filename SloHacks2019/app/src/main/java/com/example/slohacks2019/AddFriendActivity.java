package com.example.slohacks2019;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Map;

public class AddFriendActivity extends Activity {

    private TextInputLayout friendField;
    private TextInputLayout friendNumber;
    private TextInputLayout interestingFact;

    Intent intent = this.getIntent();
    Bundle bundle = intent.getExtras();

    private User user = (User) bundle.getSerializable("user");
    private Map<String, User> friendList =
            (Map<String, User>) bundle.getSerializable("friends");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void newFriend() {
        friendField = findViewById(R.id.friend_field);
        friendNumber = findViewById(R.id.friend_number);
        interestingFact = findViewById((R.id.interesting_fact));

        String name = friendField.getEditText().getText().toString();
        String number = friendNumber.getEditText().getText().toString();
        String fact = interestingFact.getEditText().getText().toString();

        user.updateName(name);
        user.updateFact(fact);

        friendList.put(user.getIdentifier(), user);
    }

}
