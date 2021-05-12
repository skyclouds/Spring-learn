package com.example.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student {
    
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbies;
    private Map<String,String> cards;
    private Set<String> games;
    private Properties info;
    private String wife;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String[] getBooks() {
        return this.books;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public List<String> getHobbies() {
        return this.hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String,String> getCards() {
        return this.cards;
    }

    public void setCards(Map<String,String> cards) {
        this.cards = cards;
    }

    public Set<String> getGames() {
        return this.games;
    }

    public void setGames(Set<String> games) {
        this.games = games;
    }

    public Properties getInfo() {
        return this.info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    public String getWife() {
        return this.wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", address='" + address.toString() + "'" +
            ", books='" + Arrays.toString(books) + "'" +
            ", hobbies='" + getHobbies() + "'" +
            ", cards='" + getCards() + "'" +
            ", games='" + getGames() + "'" +
            ", info='" + getInfo() + "'" +
            ", wife='" + getWife() + "'" +
            "}";
    }

    
}
