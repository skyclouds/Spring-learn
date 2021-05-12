package com.example.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//等价于<bean id="user" class="com.example.dao.User" />
@Component
@Scope("prototype")
public class User {

    //相当于<property name="name" value="Spring" />
    @Value("Spring")
    public String name;
    
    public String address;



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    @Value("Fuzou")
    public void setAddress(String address) {
        this.address=address;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }

}
