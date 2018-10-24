package com.company.service;

import java.util.List;

import com.company.model.User;

public interface UserService {

     User getUser(int id);

     List<User> getAllUsers();

     List<User> getSortedUsers();
     List<User> getSortedUsersDESC();

     List<String> getDeveloperId();
     List<String> getInterviewerId();

     int addUser(User user);

     int updateUser(User user);

     int deleteUser(int id);

}
