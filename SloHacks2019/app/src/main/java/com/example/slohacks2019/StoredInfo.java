package com.example.slohacks2019;

import java.util.Map;
import java.util.HashMap;

public class StoredInfo {

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

}
