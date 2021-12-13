package com.bestmanger.mangersystem.service.impl;

import com.bestmanger.mangersystem.mapper.UserDao;
import com.bestmanger.mangersystem.pojo.User;
import com.bestmanger.mangersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author liangrunyong
 * @create 2021-08-119:24
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByAccount(String account) {
        User user = userDao.findUserByAccount(account);
        return user;
    }

    @Override
    public int changePasswordByAccount(String account, String newpassword) {
        int row = userDao.changePasswordByAccount(account, newpassword);
        return row;
    }

    @Override
    public int updateUser(User user) {
        int row = userDao.updateUser(user);
        return row;
    }

    @Override
    public List<User> findAllUsers() {
        List list = userDao.findAllUsers();
        return list;
    }

    @Override
    public int deleteuser(String account) {
        int row = userDao.deleteUser(account);
        return row;
    }
}
