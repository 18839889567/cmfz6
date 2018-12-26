package com.zy;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.github.pagehelper.PageHelper;
import com.zy.entity.BannerDto;
import com.zy.entity.Menu;
import com.zy.entity.User;
import com.zy.mapper.AlbumMapper;
import com.zy.mapper.ChapterMapper;
import com.zy.mapper.UserMapper;
import com.zy.service.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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


    @Test
    public void downloaduser() {
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            user.setHeadPic("D:\\source\\cmfz\\cmfz\\src\\main\\webapp" + user.getHeadPic());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户表", "User"), User.class, users);
        try {
            workbook.write(new FileOutputStream(new File("D:/user.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void poiImport() {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);   //表格标题行数
        params.setHeadRows(1);   //表头行数
        List<User> list = ExcelImportUtil.importExcel(new File("D:/user.xls"), User.class, params);
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println(list.size());
    }


    @Test
    public void md5() {
        //e10adc3949ba59abbe56e057f20f883e
        String salt = UUID.randomUUID().toString().replace("-", "");
        System.out.println(salt);
        System.out.println(DigestUtils.md5DigestAsHex((salt + "123456").getBytes()));
    }
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
        PageHelper.startPage(1, 3);
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }

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


//        Map<String, List<Province>> map = userService.queryProvince();
//        List<Province> list = map.get("data");
//        for (Province province : list) {
//            System.out.println(province);
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

