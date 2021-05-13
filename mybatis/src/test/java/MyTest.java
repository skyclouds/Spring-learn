import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.example.mapper.UserMapper;
import com.example.pojo.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    
    @Test
    public void test() throws IOException{
        String resources="mybatis-config.xml";
        InputStream in=  Resources.getResourceAsStream(resources);
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession=sessionFactory.openSession(true);

        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        List<User> users=mapper.query();
        for(User user : users){
            System.out.println(user.toString());
        }
        
    }

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    
        UserMapper mapper=context.getBean("userMapper",UserMapper.class);
        List<User> users=mapper.query();
        for(User user : users){
            System.out.println(user.toString());
        }
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    
        UserMapper mapper=context.getBean("userMapper2",UserMapper.class);
        List<User> users=mapper.query();
        for(User user : users){
            System.out.println(user.toString());
        }
    }
}
