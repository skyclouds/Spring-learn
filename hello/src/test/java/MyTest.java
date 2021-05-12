import com.example.pojo.Hello;
import com.example.pojo.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args){
        //获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //我们的对象现在都在Spring中管理了,我们要使用,直接去里面取出来就可以
        //无论是否是使用注册的bean都会被创建
        Hello hello1=(Hello)context.getBean("hello");
        System.out.println("hello1:"+hello1.toString());    
        Hello hello2=(Hello)context.getBean("hello");
        System.out.println("hello2:"+hello2.toString());
        System.out.println(hello1==hello2);
        //根据别名取
        System.out.println("alias:"+((User)context.getBean("alias")).toString());
        System.out.println("alias1:"+((User)context.getBean("alias1")).toString());
        System.out.println("alias2:"+((User)context.getBean("alias2")).toString());
        System.out.println("alias3:"+((User)context.getBean("alias3")).toString());
        System.out.println("alias4:"+((User)context.getBean("alias4")).toString());
    }
}
