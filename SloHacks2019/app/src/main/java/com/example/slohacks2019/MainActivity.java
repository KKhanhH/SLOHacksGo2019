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
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = "0";
        try {
            deviceId = telephonyManager.getDeviceId();
        } catch(SecurityException e){
            Toast.makeText(this, "Please allow phone permissions.", Toast.LENGTH_LONG).show();
        }
        StoredInfo.updateCurrentUser(new User(deviceId));
        try {
            retrieveInformation();
        }
        catch (IOException e){
            //do nothing
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            storeInformation();
        }
        catch (IOException e) {
            //pass
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

    public void openProfile(View view){
        Intent intent = new Intent(view.getContext(),Profile.class);
        startActivity(intent);
    }

    public void openHome(View view){
        Intent intent = new Intent(view.getContext(),MainActivity.class);
        startActivity(intent);
    }

    public void openFriends(View view){
//        Intent intent = new Intent(this,Profile.class);
//        startActivity(intent);
    }

    public void storeInformation() throws IOException {
        FileOutputStream fOut = openFileOutput("friends.txt", Context.MODE_PRIVATE);
        Map<String, User> friends = StoredInfo.getFriends();
        User user;
        OutputStreamWriter outputWriter = new OutputStreamWriter(fOut);

        //display file saved message for debugging purposes
        Toast.makeText(getBaseContext(), "File saved successfully!",
                Toast.LENGTH_SHORT).show();

        for(String userID : friends.keySet()){
            user = friends.get(userID);
            outputWriter.write(user.toString());
            String seperator = System.getProperty("line.separator");
            outputWriter.append(seperator);
        }
        outputWriter.close();
    }

    public void retrieveInformation() throws IOException {
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
