package com.example.slohacks2019;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

public class AddFriendActivity extends Activity {

    private TextInputLayout friendField;
    private TextInputLayout friendNumber;
    private TextInputLayout interestingFact;

    private String userID;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_friend);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        userID = bundle.getString("user");
        user = StoredInfo.getFriends().get(userID);

    }

    protected void newFriend(View view) {
        friendField = findViewById(R.id.friend_field);
        friendNumber = findViewById(R.id.friend_number);
        interestingFact = findViewById((R.id.interesting_fact));

        String name = friendField.getEditText().getText().toString();
        String number = friendNumber.getEditText().getText().toString();
        String fact = interestingFact.getEditText().getText().toString();

        user.updateName(name);
        user.updateFact(fact);

        returnToMain();

    }

    public void returnToMain()
    {
        Intent intent = new Intent(AddFriendActivity.this, MainActivity.class);
        startActivity(intent);
    }


}
