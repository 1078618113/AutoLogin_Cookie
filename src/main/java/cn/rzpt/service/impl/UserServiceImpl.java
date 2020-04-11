package cn.rzpt.service.impl;

import cn.rzpt.dao.UserDao;
import cn.rzpt.dao.impl.UserDaoImpl;
import cn.rzpt.domain.User;
import cn.rzpt.service.UserService;

public class UserServiceImpl implements UserService {
    public User login(String username, String password) {

        UserDao userDao = new UserDaoImpl();
        User user = userDao.selectOne(username, password);
        return user;
    }

    public boolean register(String username, String password) {
        return false;
    }
}
