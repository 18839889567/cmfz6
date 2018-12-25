package com.zy.service;

import com.zy.entity.Province;
import com.zy.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public void update(User user);

    public void insert(User user);

    public List<User> queryAll();

    public User queryOne(User user);

    public List<Integer> queryByDate();

    public Map<String, List<Province>> queryProvince();
}
