package com.example.slohacks2019;

public class User {

    private String name;
    private String identifier;
    private String imagePath;

    public User(String identifier) {
        this.identifier = identifier;
        this.name = "";
        this.imagePath = "";
    }

    public User(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

    public User(String identifier, String name, String imagePath) {
        this.identifier = identifier;
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public boolean equals(Object other){
        User otherUser = (User) other;
        return this.getIdentifier() == otherUser.getIdentifier();
    }
}
