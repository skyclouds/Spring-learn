## 常用依赖
```xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.2.0.RELEASE</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/junit/junit -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>

</dependencies>
```

## 注解说明

在Spring4后,注解开发,必须导入spring-aop.jar包,同时要配置注解的支持
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```


- @Autowired:自动装配.通过类型,名字
  可以通过(required=false)指定装配的对象可以为null
  可以通过@Qualifier(value="xxx")指定装配的对象
  
- @Nullable:字段标记了这个注解说明这个字段可以为null

- @Resource:自动装配.通过类型,名字
  可以通过(name="xxx")指定装配的对象
  
- @Component:组件,放在类上,说明这个类被Spring管理了,就是Bean  
  @Component衍生注解:在web开发中会按照MVC三层架构分层
  
  dao:@Repository
  service:@Service
  controller:@Controller
  
  这四个注解功能都是一样的,都是代表将某个类注册到Spring中,装配Bean