package com.zy;

import com.zy.entity.BannerDto;
import com.zy.entity.Menu;
import com.zy.entity.User;
import com.zy.service.AdminService;
import com.zy.service.BannerService;
import com.zy.service.MenuService;
import com.zy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {
    @Autowired
    AdminService adminService;

    @Autowired
    MenuService menuService;
    @Autowired
    BannerService bannerService;
    @Autowired
    UserService userService;

    @Test
    public void UserTest() {
        User user = new User();
        long l = 1;
        user.setId(l);

        System.out.println(userService.queryOne(user));


//        List<User> list = userService.queryAll();
//        for (User user : list) {
//            System.out.println(user);
//
//        }
    }

    @Test
    public void MenuSelectAll() {
        List<Menu> list = menuService.queryAll();
        for (Menu menu : list) {
            System.out.println(menu);
        }

    }

    @Test
    public void MenuSelectById() {
        List<Menu> list = menuService.queryById("1");
        for (Menu menu : list) {
            System.out.println(menu);
        }

    }

    @Test
    public void Banner() {


    }

    @Test
    public void BannerSelectA() {
        BannerDto dto = bannerService.selectByPage(1, 5);
        System.out.println(dto);

    }
}

