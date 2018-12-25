package com.zy;

import com.zy.entity.BannerDto;
import com.zy.entity.Menu;
import com.zy.entity.Province;
import com.zy.mapper.AlbumMapper;
import com.zy.mapper.ChapterMapper;
import com.zy.mapper.UserMapper;
import com.zy.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

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
    @Autowired
    UserMapper userMapper;
    @Autowired
    AlbumService albumService;
    @Autowired
    ChapterMapper chapterMapper;
    @Autowired
    AlbumMapper albumMapper;
    @Autowired
    ChapterService chapterService;


//    @Test
//    public void AlbumServic() {
//        // List<Album> list = albumService.queryAll();
////        for (Album album : list) {
////            System.out.println(album);
////        }
//        Album album = new Album();
//        album.setId(4l);
//        System.out.println(albumService.queryById(album));
//    }

    @Test
    public void UserTest() {
//        User user = new User();
//        long l = 1;

//        user.setId(l);
//
//        System.out.println(userService.queryOne(user));


        //       List<User> list = userService.queryAll();
//        for (User user : list) {
//            System.out.println(user);
//
//        }
//       queryProvince();


//        List<Province> list = userMapper.selectProvince();
//        for (Province province : list) {
//            System.out.println(province);
//        }
        Map<String, List<Province>> map = userService.queryProvince();
        List<Province> list = map.get("data");
        for (Province province : list) {
            System.out.println(province);
        }


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

