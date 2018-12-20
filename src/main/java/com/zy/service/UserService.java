package com.zy.service;

import com.zy.entity.User;

import java.util.List;

public interface UserService {
    public void update(User user);

    public void insert(User user);

    public List<User> queryAll();

    public User queryOne(User user);
}
