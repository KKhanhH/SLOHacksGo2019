package com.example.slohacks2019;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddFriendActivity extends Activity {

    private TextInputEditText friendField;
    private TextInputEditText friendNumber;
    private TextInputEditText interestingFact;

    private String userID;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_friend);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        userID = intent.getExtras().getString("UserID");

        Log.d("UserID", userID == null ? "null" : userID);

        user = StoredInfo.getFriends().get(userID);

    }

    public void newFriend(View view) {

        Log.d("Friend", "in NewFriend");
        friendField = findViewById(R.id.friend_field);
        friendNumber = findViewById(R.id.friend_number);
        interestingFact = findViewById((R.id.interesting_fact));

        String name = friendField.getText().toString();
        String number = friendNumber.getText().toString();
        String fact = interestingFact.getText().toString();

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
