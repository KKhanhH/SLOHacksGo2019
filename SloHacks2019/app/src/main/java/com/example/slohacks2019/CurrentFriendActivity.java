package com.example.slohacks2019;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class CurrentFriendActivity extends Activity {

    private TextView name;
    private TextView fact;
    private TextView timesMet;

    private String userID;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_friend);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        userID = intent.getExtras().getString("UserID");

        Log.d("UserID", userID == null ? "null" : userID);

        user = StoredInfo.getFriends().get(userID);

        name = (TextView) findViewById(R.id.friendName);
        fact = findViewById(R.id.interestingFact);
        timesMet = findViewById(R.id.timesMet);

    }

    protected void onStart() {
        super.onStart();

        name.setText(user.getName());
        fact.setText(user.getFact());
        timesMet.setText(Integer.toString(user.meetWith()));
    }

    public void toMain(View view) {

        Intent intent = new Intent(CurrentFriendActivity.this, MainActivity.class);
        startActivity(intent);

    }

}
