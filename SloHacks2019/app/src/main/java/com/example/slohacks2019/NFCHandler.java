package com.example.slohacks2019;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class NFCHandler {

    private static String TAG = "NFCDEMO:" + MainActivity.class.getSimpleName();

    NfcAdapter mNfcAdapter;


    private void processNFCData(Intent inputIntent) {

        Log.i(TAG, "processNFCData");
        Parcelable[] rawMessages =
                inputIntent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);

        if (rawMessages != null && rawMessages.length > 0) {

            NdefMessage[] messages = new NdefMessage[rawMessages.length];

            for (int i = 0; i < rawMessages.length; i++) {

                messages[i] = (NdefMessage) rawMessages[i];

            }

            Log.i(TAG, "message size = " + messages.length);

            TextView veiw = findViewById(R.id.viewdata);
            if (veiw != null) {
                // only one message sent during the beam
                NdefMessage msg = (NdefMessage) rawMessages[0];
                // record 0 contains the MIME type, record 1 is the AAR, if present
                String base = new String(msg.getRecords()[0].getPayload());
                String str = String.format(Locale.getDefault(), "Message entries=%d. Base message is %s", rawMessages.length, base);
                veiw.setText(str);
            }

        }
    }

    private void setDisplayText ( String text ) {
        TextView veiw = findViewById(R.id.viewdata);
        if ( veiw != null ) {
            veiw.setText(text);
        }
    }




    /* **************************************************************
    This will create the NFC Adapter, if available,
    and setup the Callback listener when create message is needed.
 */
    protected void turnOnNfcBeam(MainActivity activity) {
        // Check for available NFC Adapter
        if ( mNfcAdapter == null ) {
            mNfcAdapter = NfcAdapter.getDefaultAdapter(activity);
        }
        if (mNfcAdapter == null || !mNfcAdapter.isEnabled()) {
            mNfcAdapter = null;
            Toast.makeText(activity, "NFC is not available", Toast.LENGTH_LONG).show();
            return;
        }

        // Register callback
        mNfcAdapter.setNdefPushMessageCallback(_onNfcCreateCallback, activity);
    }

    private NfcAdapter.CreateNdefMessageCallback _onNfcCreateCallback = new NfcAdapter.CreateNdefMessageCallback() {
        @Override
        public NdefMessage createNdefMessage(NfcEvent inputNfcEvent) {
            Log.i(TAG, "createNdefMessage");
            return createMessage();
        }
    };

    private NdefMessage createMessage() {
        String text = ("Hello there from another device!\n\n" +
                "Beam Time: " + System.currentTimeMillis());
        NdefMessage msg = new NdefMessage(
                new NdefRecord[] { NdefRecord.createMime(
                        "application/com.bluefletch.nfcdemo.mimetype", text.getBytes())
                        /**
                         * The Android Application Record (AAR) is commented out. When a device
                         * receives a push with an AAR in it, the application specified in the AAR
                         * is guaranteed to run. The AAR overrides the tag dispatch system.
                         * You can add it back in to guarantee that this
                         * activity starts when receiving a beamed message. For now, this code
                         * uses the tag dispatch system.
                        */
                        //,NdefRecord.createApplicationRecord("com.example.android.beam")
                });
        return msg;
    }

}
