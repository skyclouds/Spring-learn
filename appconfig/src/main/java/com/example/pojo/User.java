package com.example.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//这里这个注解到意思,就是说明这个类被Spring接管,注册到了容器中
@Component
public class User {
    private String name;

    public String getName() {
        return this.name;
    }

    //属性注入值
    @Value("Spring")
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
