package com.zy.controller;

import com.zy.entity.Admin;
import com.zy.service.AdminService;
import com.zy.util.CreateValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("login")
    public String login(Admin admin, String code, HttpSession session) {
        System.out.println("111111111111111111");
        System.out.println(admin);
        return adminService.queryByName(admin, code, session);
    }


    @RequestMapping("ImageAction")
    public String createImage(HttpSession session, HttpServletResponse response) throws Exception {

        CreateValidateCode cvc = new CreateValidateCode();
        String code = cvc.getCode();
        //存入session作用
        session.setAttribute("code", code);
        cvc.write(response.getOutputStream());

        return null;
    }
}
