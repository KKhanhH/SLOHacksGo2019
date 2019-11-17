package com.example.slohacks2019;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class StoredInfo extends Activity {

    //public static StoredInfo savedInfo = new StoredInfo();

    public static User currentUser = new User("Dummy");

    private static Map<String, User> friends = new HashMap<>();

    public static void addFriend(String identifier, User newUser){
        friends.put(identifier, newUser);
    }

    public static void removeFriend(User removedUser) {
        friends.remove(removedUser.getIdentifier());
    }

    public static Map<String, User> getFriends(){
        return friends;
    }


    public void StoreInformation(List<User> users) throws IOException {
        FileOutputStream fOut = openFileOutput("friends.txt", Context.MODE_PRIVATE);
        OutputStreamWriter outputWriter = new OutputStreamWriter(fOut);
        //display file saved message for debugging purposes
        Toast.makeText(getBaseContext(), "File saved successfully!",
                Toast.LENGTH_SHORT).show();



        for(User user : users){
            outputWriter.write(users.toString());
            String seperator = System.getProperty("line.separator");
            outputWriter.append(seperator);
        }
        outputWriter.close();
    }

    public List<User> retrieveInformation() throws FileNotFoundException {
        FileInputStream fileIn=openFileInput("mytextfile.txt");
        InputStreamReader InputRead= new InputStreamReader(fileIn);

        //Parse the file into different users and create a list of users

        return null;

    }



}
