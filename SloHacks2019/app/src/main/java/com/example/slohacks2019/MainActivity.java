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
    }

    public void startSend(View view)
    {
        Intent intent = new Intent(MainActivity.this, SendNFC.class);
        startActivity(intent);
    }

    public void startReceive(View view)
    {
        Intent intent = new Intent(MainActivity.this, ReceiveNFC.class);
        startActivity(intent);
    }

}
