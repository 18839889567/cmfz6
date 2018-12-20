package com.zy.service;

import com.zy.entity.Admin;

import javax.servlet.http.HttpSession;

public interface AdminService {
    public String queryByName(Admin admin, String code, HttpSession session);
}
