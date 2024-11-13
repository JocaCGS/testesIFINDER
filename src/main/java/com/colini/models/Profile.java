package com.colini.models;

public class Profile {
    private final String name;
    private final int age;
    private final String imagePath; // Field to store image path

    public Profile(String name, int age, String imagePath) {
        this.name = name;
        this.age = age;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getImagePath() {
        return imagePath;
    }
}
