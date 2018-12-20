package com.zy.service;

import com.zy.entity.Admin;
import com.zy.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public String queryByName(Admin admin, String code, HttpSession session) {
        String code1 = (String) session.getAttribute("code");
        if (!code1.equalsIgnoreCase(code)) {
            return "验证码错误";
        } else {
            Admin admin1 = adminMapper.selectOne(admin);
            System.out.println(admin1);
            if (admin1 == null) {
                return "或者密码错误";
            } else {
                return "ok";
            }
        }
    }
}
