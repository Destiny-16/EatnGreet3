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


    public User(){}



public  User(String fact, String food, String name, String restaurant, String gender, String age) {
    this.fact = fact;
    this.name = name;
    this.food = food;
    this.restaurant = restaurant;
    this.gender = gender;
    this.age = age;

}

}


