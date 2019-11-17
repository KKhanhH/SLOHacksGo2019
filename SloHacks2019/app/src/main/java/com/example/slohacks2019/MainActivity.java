package com.example.slohacks2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = telephonyManager.getDeviceId();
        StoredInfo.updateCurrentUser(new User(deviceId));
        try {
            retrieveInformation();
        }
        catch (IOException e){
            //do nothing
        }
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

    public void StoreInformation(List<User> users) throws IOException {
        FileOutputStream fOut = openFileOutput("friends.txt", Context.MODE_PRIVATE);
        OutputStreamWriter outputWriter = new OutputStreamWriter(fOut);
        //display file saved message for debugging purposes
        Toast.makeText(getBaseContext(), "File saved successfully!",
                Toast.LENGTH_SHORT).show();

        for(User user : users){
            outputWriter.write(user.toString());
            String seperator = System.getProperty("line.separator");
            outputWriter.append(seperator);
        }
        outputWriter.close();
    }

    public void retrieveInformation() throws IOException {
        //List<User> friendsList = new ArrayList<>();
        try{
            FileInputStream fileIn= openFileInput("friends.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            BufferedReader reader = new BufferedReader(InputRead);
            String str = "";

            while ((str = reader.readLine()) != null) {
                //parse the input, each entities is split by space
                String[] parseData = str.split(" ");
                //0 -> identifier
                //1 -> name
                //2 -> imagePath
                //3 -> timeMet
                StoredInfo.addFriend(parseData[0], new User(parseData[0],
                                    parseData[1], parseData[2],
                                    Integer.parseInt(parseData[3])));
            }

        }catch(FileNotFoundException e){
            //File is not presented, create a empty file
            FileOutputStream fOut = openFileOutput("friends.txt", Context.MODE_PRIVATE);
            //e.printStackTrace();
        }

        //Parse the file into different users and create a list of users

    }



}
