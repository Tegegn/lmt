package com.ttf.lmt.service;

import com.ttf.lmt.entity.User;

import java.util.List;

public interface UserService {

    User getUser(Long userId);

    List<User> getAllUsers();

    User createUser(User user);

    User updatedUser(User user);

    void deleteUser(Long id);
}
