package com.example.pojo;

public class Address {
    private String address;


    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "{" +
            " address='" + getAddress() + "'" +
            "}";
    }

}
