package com.zy.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.zy.entity.Province;
import com.zy.entity.User;
import com.zy.entity.UserDto;
import com.zy.mapper.UserMapper;
import com.zy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.*;

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
    public void delete(User user) {
        userMapper.delete(user);
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
    public UserDto queryByPage(Integer pageNum, Integer pageSize) {
        UserDto dto = new UserDto();
        PageHelper.startPage(pageNum, pageSize);
        dto.setRows(userMapper.selectAll());
        dto.setTotal(userMapper.selectCount(new User()));
        return dto;
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


    public String insertUser(User user, String newCode, HttpSession session) {

        String code = (String) session.getAttribute("code");
        if (!code.equals(newCode)) {
            return "验证码有误!";
        }
        String salt = UUID.randomUUID().toString().replace("-", "");
        user.setSalt(salt);
        user.setPassword(DigestUtils.md5DigestAsHex((salt + user.getPassword()).getBytes()));
        userMapper.insert(user);
        return "ok";
    }

}
