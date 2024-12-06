package com.notes.services;

import com.notes.entities.User;

import java.util.List;

public interface UserService {

    //Create
    User saveUser(User user);
    //Read
    List<User> fetchUserList();
    User findUserById(User user, Integer userId);
    //Update
    User updateUser(User user, Integer userId);
    //Delete
    void deleteUserById(Integer userId);
}
