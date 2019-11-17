package com.example.slohacks2019;

import android.app.Activity;
import android.content.Context;
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
import java.util.HashMap;

public class StoredInfo extends Activity {

    //public static StoredInfo savedInfo = new StoredInfo();

    private static User currentUser = new User("Dummy");

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

    public static User getCurrentUser(){
        return currentUser;
    }

    public static void updateCurrentUser(User newUser){
        currentUser = newUser;
    }


}
