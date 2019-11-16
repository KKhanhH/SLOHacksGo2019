package com.example.slohacks2019;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Map;

public class AddFriendActivity extends Activity {

    private TextInputLayout friendField;
    private TextInputLayout friendNumber;
    private TextInputLayout interestingFact;

    Intent intent = this.getIntent();
    Bundle bundle = intent.getExtras();

    private String userID = bundle.getString("user");
    private User user = StoredInfo.getFriends().get(userID);

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

    }

    public void returnToMain(View view)
    {
        Intent intent = new Intent(AddFriendActivity.this, MainActivity.class);
        startActivity(intent);
    }


}
