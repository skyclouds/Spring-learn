import java.util.List;

import com.example.mapper.UserMapper;
import com.example.pojo.User;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    
        UserMapper mapper=context.getBean("userMapper",UserMapper.class);
        List<User> users=mapper.query();
        for(User user : users){
            System.out.println(user.toString());
        }
    }

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    
        UserMapper mapper=context.getBean("userMapper",UserMapper.class);
        List<User> users=mapper.test1();
        for(User user : users){
            System.out.println(user.toString());
        }
    }
}
