import com.example.pojo.Student;
import com.example.pojo.User;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void setterBasedTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
    }

    @Test
    public void namespaceTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user.toString());
        User user2 = context.getBean("user2", User.class);
        System.out.println(user2.toString());
    }

    @Test
    public void scopeTest() {
        //Spring 默认单例模式
        ApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user1==user2);
    }
}