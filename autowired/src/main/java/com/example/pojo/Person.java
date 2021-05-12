package com.example.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
/**
 * Autowired
 * 直接在属性上使用,或者set方法上使用
 * 使用Autowired可以不需要写set方法,前提是自动装配的属性在IOC(Spring)容器中存在,且符合名字byName
 */
public class Person {
    
    //如果定义required为false,说明这个对象可以为null,否则不许允许为空
    @Autowired(required =false)
    private Cat cat;
    @Autowired
    @Qualifier(value = "dog2")
    private Dog dog;
    private String name;


    public Person(@Nullable String name) {
        this.name = name;
    }

    public Cat getCat() {
        return this.cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return this.dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "{" +
            " cat='" + getCat() + "'" +
            ", dog='" + getDog() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

}
