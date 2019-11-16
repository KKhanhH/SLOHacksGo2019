package com.example.slohacks2019;

public class User {

    private String name;
    private String identifier;
    private String imagePath;
    private String fact;
    private int timesMet;
    private int timesMetConsecutively;

    public User(String identifier) {
        this.identifier = identifier;
        this.name = "";
        this.imagePath = "";
        fact = "";
        timesMet = 0;
        timesMetConsecutively = 0;
    }

    public User(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
        fact = "";
        timesMet = 0;
        timesMetConsecutively = 0;

    }

    public User(String identifier, String name, String imagePath) {
        this.identifier = identifier;
        this.name = name;
        this.imagePath = imagePath;
        fact = "";
        timesMet = 0;
        timesMetConsecutively = 0;

    }

    public String getName() {
        return name;
    }

    public String getFact() {
        return fact;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateImagePath(String path) {
        this.imagePath = path;
    }

    public void updateFact(String fact) {
        this.fact = fact;
    }

    public void meetWith() {
        timesMet++;
    }

    @Override
    public boolean equals(Object other){
        if (other == null || other.getClass() != getClass())
            return false;

        User otherUser = (User) other;
        return this.getIdentifier().equals(otherUser.getIdentifier());
    }
}
