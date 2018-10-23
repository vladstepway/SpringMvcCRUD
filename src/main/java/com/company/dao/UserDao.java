package com.company.dao;

import java.util.List;

import com.company.model.User;

public interface UserDao {

    public User getUser(int id);

    public List<User> getAllUsers();

    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUser(int id);

}
