package com.example.slohacks2019;

import java.util.ArrayList;

public class StoredInfo {

    public static StoredInfo savedInfo = new StoredInfo();

    public User currentUser;

    private ArrayList<User> friends = new ArrayList<User>();

    public void addFriend(User newUser){
        friends.add(newUser);
    }

    public void removeFriend(User removedUser) {
        friends.remove(removedUser);
    }

    public ArrayList<User> getFriends(){
        return friends;
    }

}
