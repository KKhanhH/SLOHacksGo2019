package com.example.slohacks2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ReceiveNFC extends AppCompatActivity {

    private TextView mTextView;
    private String receivedString = "";
    private boolean receivedSignal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_nfc);
        mTextView = (TextView) findViewById(R.id.mTextView);

        while (!receivedSignal)
            waitingForSignal();
    }


    protected void waitingForSignal(){
        //super.onResume();
        Intent intent = getIntent();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            Parcelable[] rawMessages = intent.getParcelableArrayExtra(
                    NfcAdapter.EXTRA_NDEF_MESSAGES);

            NdefMessage message = (NdefMessage) rawMessages[0]; // only one message transferred
            receivedString = new String(message.getRecords()[0].getPayload());
            User user = StoredInfo.getFriends().get(receivedString);
            if (user == null)
                newFriend(receivedString);


            mTextView.setText(Integer.toString(user.meetWith()));
            receivedSignal = true;

        } else
            mTextView.setText("Waiting for NDEF Message");

    }

    public void returnToMain(View view)
    {
        Intent intent = new Intent(ReceiveNFC.this, MainActivity.class);
        startActivity(intent);
    }

    public void newFriend(String receivedString) {
        User user = new User(receivedString);
        StoredInfo.addFriend(receivedString, user);

        Intent sendNFCIntent = new Intent(ReceiveNFC.this,
                AddFriendActivity.class);

        sendNFCIntent.putExtra("UserID", receivedString);
        startActivity(sendNFCIntent);

    }
}
