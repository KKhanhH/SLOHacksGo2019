package com.example.slohacks2019;

import java.util.Map;
import java.util.HashMap;

public class StoredInfo {

    public static StoredInfo savedInfo = new StoredInfo();

    public User currentUser;

    private Map<String, User> friends = new HashMap<>();

    public void addFriend(String identifier, User newUser){
        friends.put(identifier, newUser);
    }

    public void removeFriend(User removedUser) {
        friends.remove(removedUser.getIdentifier());
    }

    public Map<String, User> getFriends(){
        return friends;
    }

}
