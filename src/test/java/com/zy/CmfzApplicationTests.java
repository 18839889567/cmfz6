package com.zy;

import com.zy.entity.BannerDto;
import com.zy.entity.Menu;
import com.zy.service.AdminService;
import com.zy.service.BannerService;
import com.zy.service.MenuService;
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

    @Test
    public void contextLoads() {
        // System.out.println(adminService.queryByName(new Admin(null,"123456","123456")));

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

