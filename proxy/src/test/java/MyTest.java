import com.example.demo1.Host;
import com.example.demo1.Proxy;
import com.example.ProxyInvocationHandler;
import com.example.demo1.Rent;
import com.example.demo2.UserService;
import com.example.demo2.UserServiceMySQLImpl;
import com.example.demo2.UserServiceOracleImpl;
import com.example.demo2.UserServiceProxy;

import org.junit.Test;

public class MyTest {
    
    @Test
    public void test1() {
        //房东要租房子
        Host host = new Host();
        //代理,中介帮房东租房子,但是代理角色一般会有一些附属操作
        Proxy proxy = new Proxy(host);
        
        //你不用面对房东,直接找中介租房即可
        proxy.rent();
    }

        
    @Test
    public void test2() {
        UserServiceMySQLImpl userService = new UserServiceMySQLImpl();
        
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);

        proxy.insert();
        proxy.delete();
        proxy.update();
        proxy.query();

    }

    @Test
    public void test3() {
        //真实角色
        //UserServiceMySQLImpl userService = new UserServiceMySQLImpl();
        UserServiceOracleImpl userService = new UserServiceOracleImpl();

        //代理角色:通过调InvocationHandler来处理我们调用的接口对象
        ProxyInvocationHandler pih=new ProxyInvocationHandler();
        pih.setTarget(userService);
        //动态生成代理类
        UserService proxy=(UserService)pih.getProxy();

        proxy.insert();
    }
}
