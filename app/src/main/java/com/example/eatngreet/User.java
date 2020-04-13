package com.example.eatngreet;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public String fact;
    public String food;
    public String name;
    public String restaurant;
    public String gender;
    public String age;
    public int getName;
    private String id;
    private String imageURL;

    public User(String id, String name, String imageURL){
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
    }

    public  User(String fact, String food, String name, String restaurant, String gender, String age) {
        this.fact = fact;
        this.name = name;
        this.food = food;
        this.restaurant = restaurant;
        this.gender = gender;
        this.age = age;

    }

    public User(){

    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public String getName(){ return name; }

    public void setUsername(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}



