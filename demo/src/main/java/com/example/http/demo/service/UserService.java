package com.example.http.demo.service;

import com.example.http.demo.mapper.UserMapper;
import com.example.http.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User findById(Long id) {
        return userMapper.findById(id);
    }

    public void create(User user) {
        userMapper.insert(user);
    }

    public void update(Long id, User user) {
        user.setId(id);
        userMapper.update(user);
    }

    public void delete(Long id) {
        userMapper.delete(id);
    }
}
