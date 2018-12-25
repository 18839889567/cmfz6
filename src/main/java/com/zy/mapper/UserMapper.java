package com.zy.mapper;

import com.zy.entity.Province;
import com.zy.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    public Integer selectByDate(Integer day);

    public List<Province> selectProvince();
}
