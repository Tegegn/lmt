package com.ttf.lmt.service.impl;

import com.ttf.lmt.entity.User;
import com.ttf.lmt.mapper.UserMapper;
import com.ttf.lmt.repo.UserRepository;
import com.ttf.lmt.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class UserBusinessService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Long userId) {
        //return userMapper.getUserById(userId);
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        if (Objects.nonNull(user)){
            user.setUpdatedAt(LocalDateTime.now());
        }
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User updatedUser(User user) {
        return userRepository.findById(user.getId())
                .map(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword());
                    existingUser.setUpdatedAt(LocalDateTime.now());
                    return userRepository.saveAndFlush(existingUser);
                })
                .orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User with id " + id + " not found!");
        }
        userRepository.deleteById(id);
    }
}
