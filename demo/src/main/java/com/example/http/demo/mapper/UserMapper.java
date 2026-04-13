package com.example.http.demo.mapper;

import com.example.http.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    User findById(Long id);
    void insert(User user);
    void update(User user);
    void delete(Long id);
}
