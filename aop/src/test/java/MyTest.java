import com.example.service.UserService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("method1.xml");
        //注意:动态代理代理的是接口
        UserService userService = (UserService)context.getBean("userService");
        userService.insert();
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("method2.xml");
        //注意:动态代理代理的是接口
        UserService userService = (UserService)context.getBean("userService");
        userService.insert();
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("method3.xml");
        //注意:动态代理代理的是接口
        UserService userService = (UserService)context.getBean("userService");
        userService.insert();
    }
}
