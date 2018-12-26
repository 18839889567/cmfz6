package com.zy.serviceImpl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.zy.entity.Album;
import com.zy.entity.User;
import com.zy.mapper.AlbumMapper;
import com.zy.mapper.UserMapper;
import com.zy.service.PoiService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class PoiServiceImpl implements PoiService {
    @Autowired
    AlbumMapper albumMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public void downloadAlbum() {
        List<Album> album = albumMapper.all();
        for (Album a : album) {
            System.out.println(a);
            a.setCoverImg("D:\\source\\cmfz\\cmfz\\src\\main\\webapp" + a.getCoverImg());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑&音频", "吉祥妙音"), Album.class, album);
        try {
            workbook.write(new FileOutputStream(new File("D:/easypoi.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void poiImportAlbum() {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);   //表格标题行数
        params.setHeadRows(2);   //表头行数
        List<Album> list = ExcelImportUtil.importExcel(new File("D:/easypoi.xls"), Album.class, params);
        for (Album album : list) {
            System.out.println(album);
        }
        System.out.println(list.size());
    }

    @Override
    public void downloadUser() {
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

    @Override
    public void poiImportUser() {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);   //表格标题行数
        params.setHeadRows(1);   //表头行数
        List<User> list = ExcelImportUtil.importExcel(new File("D:/user.xls"), User.class, params);
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println(list.size());
    }


}
