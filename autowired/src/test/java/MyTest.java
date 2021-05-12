import com.example.pojo.People;
import com.example.pojo.Person;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person =context.getBean("person",Person.class);
        person.getCat().shout();
        person.getDog().shout();
    }


    @Test
    public void autoWiredTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowired.xml");
        Person person =context.getBean("person",Person.class);
        person.getCat().shout();
        person.getDog().shout();
    }

    @Test
    public void resourceTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("resource.xml");
        People people =context.getBean("people",People.class);
        people.getCat().shout();
        people.getDog().shout();
    }
}
