package com.example.pojo;

public class Hello {
    
    public Hello() {
        System.out.println("Hello create");
    }

    public Hello(String name) {
        this.name = name;
        System.out.println("Hello"+"["+name+"]"+" create");
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
