package com.zy.mapper;

import com.zy.entity.Menu;

import java.util.List;

public interface MenuMapper {
    public List<Menu> queryAll();

    public List<Menu> queryById(String id);
}
