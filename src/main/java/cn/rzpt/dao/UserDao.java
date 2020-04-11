package cn.rzpt.dao;

import cn.rzpt.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> selectAll();

    public User selectOne(String username, String password);

    public boolean register(String username, String passowrd);
}
