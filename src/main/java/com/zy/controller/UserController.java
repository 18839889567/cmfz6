package com.zy.controller;

import com.zy.entity.Province;
import com.zy.mapper.UserMapper;
import com.zy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @RequestMapping("queryByDate")
    public List<Integer> queryByDate() {

        return userService.queryByDate();
    }

    @RequestMapping("province")
    public Map<String, List<Province>> queryProvince() {
        return userService.queryProvince();
    }

    @RequestMapping("province2")
    public List<Province> queryProvince2() {
        return userMapper.selectProvince();
    }

}
