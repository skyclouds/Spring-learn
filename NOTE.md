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

    <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.9.4</version>
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
  
  - dao:@Repository
  - service:@Service
  - controller:@Controller
  
  这四个注解功能都是一样的,都是代表将某个类注册到Spring中,装配Bean

## 静态代理
角色分析:
- 抽象角色:一般用接口或者抽象类实现
- 真实角色:被代理的角色
- 代理角色:代理真实角色,代理真实角色后,一般会有一些附属操作
- 用户:访问代理对象的人

优点:
- 真实角色更加纯粹,不需要关注公共业务
- 代理角色处理公共业务,实现业务分工
- 方便管理和扩展公共业务

缺点:
- 一个真实角色就会产生一个代理角色,代码量会翻倍,开发效率低

## 动态代理

- 动态代理与静态代理角色一样
- 动态代理的代理类是动态生成的
- 动态代理分为两大类:基于接口的动态代理,基于类的动态代理
  - 基于接口:JDK动态代理
  - 基于类:cglib
  - java字节码实现:javassist

需要了解两个类:Proxy:代理,InvocationHandler:调用处理程序

优点:
- 真实角色更加纯粹,不需要关注公共业务
- 代理角色处理公共业务,实现业务分工
- 方便管理和扩展公共业务
- 动态代理的代理的是一个接口,一般就是对应一个业务
- 一个动态代理类可以代理多个类,只要是实现了同一个接口即可

## AOP
须导入aspectjweaver.jar包

方式一:使用Spring API接口

方式二:自定义实现AOP

## 事务管理
- 声明式事务管理:AOP
- 编程式事务管理:在代码中进行事务管理(通过catch让事务回滚,不推荐)