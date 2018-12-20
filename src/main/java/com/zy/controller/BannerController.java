package com.zy.controller;

import com.zy.entity.Banner;
import com.zy.entity.BannerDto;
import com.zy.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("banner")
public class BannerController {
    @Autowired
    BannerService bannerService;

    @RequestMapping("queryByPage")
    public BannerDto queryByPage(Integer page, Integer rows) {
        return bannerService.selectByPage(page, rows);
    }

    @RequestMapping("delete")
    public void queryByPage(Banner banner) {
        bannerService.delete(banner);
    }

    @RequestMapping("insert")
    public void insert(Banner banner, HttpSession session, MultipartFile file) {
        try {
            bannerService.insert(banner, session, file);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @RequestMapping("update")
    public void update(Banner banner) {
        bannerService.updete(banner);
    }
}
