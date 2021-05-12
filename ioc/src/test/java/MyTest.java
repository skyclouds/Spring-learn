import com.example.dao.UserDaoMySQLImpl;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args){

        //用户实际调用的是业务层,dao层他们不需要接触
        UserService userService = new UserServiceImpl();

        ((UserServiceImpl)userService).setUserDao(new UserDaoMySQLImpl());

        userService.getUser();
    }
}
