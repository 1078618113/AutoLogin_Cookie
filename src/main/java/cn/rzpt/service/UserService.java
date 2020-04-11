package cn.rzpt.service;

import cn.rzpt.domain.User;

public interface UserService {
    public User login(String username, String password);

    public boolean register(String username,String password);
}
