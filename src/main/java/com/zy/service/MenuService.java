package com.zy.service;

import com.zy.entity.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> queryAll();

    public List<Menu> queryById(String id);
}
