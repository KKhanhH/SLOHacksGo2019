package com.example.slohacks2019;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private View.OnClickListener _onBeamClick = new View.OnClickListener() {
        @Override
        public void onClick(View inputView) {
            Log.i(TAG, "_onBeamClick onClick");
            turnOnNfcBeam(this);
        }
    };
}
