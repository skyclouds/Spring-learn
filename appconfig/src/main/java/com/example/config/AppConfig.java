package com.example.config;

import com.example.pojo.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//这个也会被Spring托管,注册到容器中,因为他本来就是一个@Component
//@Configuration代表这个是一个配置类,就是.xml配置文件
@Configuration
@ComponentScan("com.example")
@Import(AppConfig2.class)
public class AppConfig {
    
    //注册一个Bean,就相当于之前写到bean标签
    //这个方法到名字就相当于bean标签中到id属性
    //这个方法到返回值相当于bean标签中到class属性
    @Bean
    public User user(){
        //返回到就是要注入到bean到对象
        return new User();
    }

}
