package com.example.pojo;

public class User {
    
    public User() {
        System.out.println("User create");
    }

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            "}";
    }

}
