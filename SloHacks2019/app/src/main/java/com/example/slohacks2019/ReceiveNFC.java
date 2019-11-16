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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_nfc);
        mTextView = (TextView) findViewById(R.id.mTextView);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Intent intent = getIntent();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            Parcelable[] rawMessages = intent.getParcelableArrayExtra(
                    NfcAdapter.EXTRA_NDEF_MESSAGES);

            NdefMessage message = (NdefMessage) rawMessages[0]; // only one message transferred
            receivedString = new String(message.getRecords()[0].getPayload());
            if (StoredInfo.getFriends().containsKey(receivedString))
                StoredInfo.getFriends().get(receivedString).meetWith();
            else {
                //Intent sendNFCIntent = new Intent(MainActivity.this, SendNFC.class);
                //MainActivity.this.startActivity(sendNFCIntent);

            }
            mTextView.setText(receivedString);

        } else
            mTextView.setText("Waiting for NDEF Message");

    }

    public void returnToMain(View view)
    {
        Intent intent = new Intent(ReceiveNFC.this, MainActivity.class);
        startActivity(intent);
    }
}
