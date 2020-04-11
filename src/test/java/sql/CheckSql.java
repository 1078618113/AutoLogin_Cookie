package sql;

import cn.rzpt.dao.impl.UserDaoImpl;
import cn.rzpt.domain.User;
import org.junit.Test;

import java.util.List;

public class CheckSql {
    @Test
    public void selectAllTest(){
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> list = userDao.selectAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void selectOneTest(){
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.selectOne("admin","admin");
        System.out.println(user);
    }


    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
