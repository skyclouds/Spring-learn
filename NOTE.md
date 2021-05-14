# Spring

- IoC:控制反转
- AOP:面向切面编程

## 依赖

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>
```

## XML配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
    <!-- 导入别的配置-->    
    <import resource="xxx.xml" />    
    <!-- 使用Spring来创建对象,在Spring中这些都称为Bean
        类型 变量名 = new 类型();
        Hello hello= new Hello();
        
        id : bean的唯一标识符
        class : bean对象所应对全限定名(包名+类名)
        name :也是别名,而且可以同时取多个别名,分隔符多样(空格,;)
    -->
    <bean id="bean名称" class="类的全限定名(包名+类名)" name="别名1 别名2,别名3;别名4"/>  
    <!-- 别名,如果添加了别名,也可以使用别名获得这个对象-->
    <alias name="bean名称" alias="别名" />

</beans>
```

## 注解配置

- @Configuration
- @ComponentScan("com.*.*")
- @Import(XXX.class)

- @Component
  - @Value("xxx")

## 运行

### XML方式

```java
ApplicationContext context = new ClassPathXmlApplicationContext("xxx.xml");
```
### 注解方式

```java
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(XXX.class);
```
## IoC

Inversion of Control 是一种设计思想

传统开发

- Dao接口
- Impl实现类
- Service业务接口
- ServiceImpl业务实现接口

传统开发中业务固化在代码中,如果业务变更则需要修改代码

通过一个set接口就能实现控制反转

控制反转就是通过描述(XML或者注解)通过第三方生成或获取特定对象的方式

## DI

Spring中实现控制反转的是IoC容器,其实现方式是依赖注入(Dependency Injection.DI)

### XML配置

```xml
<beans 
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

  <!-- 
      scope:作用域(默认singleton) 
  -->
  <bean id="bean名称" class="类的全限定名(包名+类名)" scope="prototype">
      <!--基本注入-->
      <property name="属性名" value="属性值"></property>

      <property name="属性名">
          <value>属性值</value>
      </property>

      <!--对象注入-->
      <property name="属性名" ref="对象bean名称"></property>

      <!-- 数组注入 -->
      <property name="属性名">
        <array>
            <value>数据[n]</value>
        </array>
      </property>
      <!-- List注入 -->
      <property name="属性名">
          <list>
              <value>数据[n]</value>
          </list>
      </property>
      <!-- Set注入 -->
      <property name="属性名">
          <set>
              <value>数据[n]</value>
          </set>
      </property>
      <!-- Properties注入 -->
      <property name="属性名">
          <props>
              <prop key="属性键[n]">属性键值[n]</prop>
          </props>
      </property>
      <!-- null注入 -->
      <property name="属性名">
        <null/>
      </property> 

      <!--有参构造1:通过下标赋值-->
      <constructor-arg index="0" value="Srping"/>
      <!--有参构造2:通过类型创建,不建议使用,如果有多个相同类构造参数有问题-->
      <constructor-arg type="java.lang.String" value="属性值"/>
      <!--有参构造3:直接通过参数名-->
      <constructor-arg name="属性名" value="属性值" />
  </bean>

</beans>
```

## 自动装配

### XML配置

```xml
<beans 
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 
        byName:会自动在容器上下文查找,和自己对象set方法后面的值对应的beanid
               需要保证所有bean的id唯一,并且这个bean需要和自动注入的set方法的值一致
        byType:会自动在容器上下文查找,和自己对象属性类型相同的bean
               需要保证所有bean的class唯一,并且这个bean需要和自动注入的属性的类型一致
    -->
    <bean id="bean名称" class="类的全限定名(包名+类名)" autowire="byName">
        <property name="属性名" value="属性值" />
    </bean>
</beans>
```
### 注解配置

开启注解配置

```xml
<beans 
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 开启注解解释 -->
    <context:annotation-config/>
    <!-- 指定要扫描的包,这个包下的注解就会生效 -->
    <context:component-scan base-package="com.*.*"/>
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

## AOP

### 静态代理
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

### 动态代理

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

### AOP织入

方式一:使用Spring API接口

方式二:自定义实现AOP

### 依赖

```xml
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
<dependency>
  <groupId>org.aspectj</groupId>
  <artifactId>aspectjweaver</artifactId>
  <version>1.9.4</version>
</dependency>
```
### XML配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- 方法一:使用原生Spring API接口 -->
    <bean id="bean名称" class="类的全限定名(包名+类名)"></bean>

    <aop:config>
        <!-- 切入点:expression:表达式,execution(返回类型 包名 类名 方法名)-->
        <aop:pointcut id="切入点名称" expression="execution(* com.*.*(..))" />

        <!-- 执行环绕增强-->
        <aop:advisor advice-ref="bean名称" pointcut-ref="切入点名称" />
    </aop:config>

    <!-- 方法二:自定义类 -->
    <aop:config>
        <!-- 自定义切面,ref要引用的类 -->
        <aop:aspect ref="bean名称">
        <!-- 切入点:expression:表达式,execution(返回类型 包名 类名 方法名)-->
        <aop:pointcut id="切入点名称" expression="execution(* com.*.*(..))" />
        <!-- 通知-->
        <aop:before method="bean应对类中的方法" pointcut-ref="切入点名称"/>
        <aop:after method="bean应对类中的方法" pointcut-ref="切入点名称"/>
        </aop:aspect>
    </aop:config>

     <!-- 开启注解支持 proxy-target-class:APO方式,false:JDK(默认),true:cglib-->
    <aop:aspectj-autoproxy proxy-target-class="true"/>

</beans>
```

### 注解配置
- @Aspect
- @Before("execution(* execution(* com.*.*(..))")
- @After("execution(* execution(* com.*.*(..))")
- @Around("execution(* com.*.*(..))")

## 事务管理
- 声明式事务管理:AOP
- 编程式事务管理:在代码中进行事务管理(通过catch让事务回滚,不推荐)

### XML配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" 
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
       xmlns:aop="http://www.springframework.org/schema/aop" 
       xmlns:tx="http://www.springframework.org/schema/aop" 
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/tx
        https://www.springframework.org/schema/tx/spring-tx.xsd">
    
    <!-- 结合AOP实现事务的织入 -->
    <!-- 配置事务的类 -->
    <tx:advice id="事务名称" transaction-manager="transactionManager">
        <!-- 给哪些事务配置事务-->
        <!-- 配置事务的传播特性-->
        <tx:attributes>
            <!-- <tx:method name="insert" propagation="REQUIRED"/>
            <tx:method name="query" read-only="true"/> -->
            <tx:method name="*" propagation="REQUIRED"/>
        </tx:attributes>
    </tx:advice>

    <!-- 配置事务切入 -->
    <aop:config>
        <aop:pointcut id="切入点名称" expression="execution(* com.*.*(..))" />
        <aop:advisor advice-ref="事务名称" pointcut-ref="切入点名称" />
    </aop:config>    

</bean>            
```