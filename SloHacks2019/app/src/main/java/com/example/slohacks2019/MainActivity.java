package com.example.slohacks2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button sendNFCButton = (Button) findViewById(R.id.sendNFC);
        sendNFCButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //add your code here..
                Intent sendNFCIntent = new Intent(MainActivity.this, SendNFC.class);
                MainActivity.this.startActivity(sendNFCIntent);

                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.screenBrightness = 0;
                getWindow().setAttributes(params);
            }
        });

        final Button receiveNFCButton = (Button) findViewById(R.id.receiveNFC);
        receiveNFCButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //add your code here..
                Intent receiveNFCIntent = new Intent(MainActivity.this, ReceiveNFC.class);
                MainActivity.this.startActivity(receiveNFCIntent);

                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.screenBrightness = 0;
                getWindow().setAttributes(params);
            }
        });
    }

}
