package com.zy;

import com.zy.entity.*;
import com.zy.mapper.AlbumMapper;
import com.zy.mapper.ChapterMapper;
import com.zy.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
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
    @Autowired
    AlbumService albumService;
    @Autowired
    ChapterMapper chapterMapper;
    @Autowired
    AlbumMapper albumMapper;
    @Autowired
    ChapterService chapterService;

    @Test
    public void chapterMapper(HttpSession session, HttpServletResponse response) throws IOException {
//        List<Chapter> list = chapterMapper.selectAll();
//        for (Chapter chapter : list) {
//            System.out.println(chapter);
//        }
//        Album album = new Album();
//        System.out.println(albumMapper.selectCount(album));
        //chapterService.download("/很美味 - 东西.mp3",session,response);
        Chapter chapter = new Chapter(null, "111", 11.0, "111", "111.ma3", new Date(), 4l);
        chapterMapper.insert(chapter);
    }

    @Test
    public void AlbumServic() {
        // List<Album> list = albumService.queryAll();
//        for (Album album : list) {
//            System.out.println(album);
//        }
        Album album = new Album();
        album.setId(4l);
        System.out.println(albumService.queryById(album));
    }

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

