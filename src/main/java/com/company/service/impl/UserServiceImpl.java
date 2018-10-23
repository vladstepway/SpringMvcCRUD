package com.company.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.model.User;
import com.company.dao.UserDao;
import com.company.service.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(int id) {
        return userDao.getUser(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    public UserDao getUserDao() {
        return userDao;
    }

}