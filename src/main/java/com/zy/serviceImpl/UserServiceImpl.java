package com.zy.serviceImpl;

import com.zy.entity.Province;
import com.zy.entity.User;
import com.zy.mapper.UserMapper;
import com.zy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.selectAll();
    }

    @Override
    public User queryOne(User user) {
        return userMapper.selectOne(user);
    }

    @Override
    public List<Integer> queryByDate() {
        List<Integer> list = new ArrayList<>();
        list.add(userMapper.selectByDate(7));
        list.add(userMapper.selectByDate(14));
        list.add(userMapper.selectByDate(21));
        return list;
    }

    @Override
    public Map<String, List<Province>> queryProvince() {

        HashMap<String, List<Province>> map = new HashMap<>();
        map.put("data", userMapper.selectProvince());
        return map;
    }
}
