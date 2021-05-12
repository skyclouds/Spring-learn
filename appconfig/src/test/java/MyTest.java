import com.example.config.AppConfig;
import com.example.pojo.User;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    
    @Test
    public void test(){
        //如果完全使用了配置类方式取做,我们就只能通过AnnotationConfig上下文来获取容器,通过配置类到class对象加载
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User user=context.getBean("user",User.class);
        System.out.println(user.toString());
    }
}
