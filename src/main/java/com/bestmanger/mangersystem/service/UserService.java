package com.bestmanger.mangersystem.service;

import com.bestmanger.mangersystem.pojo.User;

import java.util.List;

/**
 * @author liangrunyong
 * @create 2021-08-119:23
 */
public interface UserService {
    public User findUserByAccount(String account);

    public int changePasswordByAccount(String account, String newpassword);

    public int updateUser(User user);

    public List<User> findAllUsers();

    public int deleteuser(String account);
}
