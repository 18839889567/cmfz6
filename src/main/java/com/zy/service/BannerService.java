package com.zy.service;

import com.zy.entity.Banner;
import com.zy.entity.BannerDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface BannerService {
    public void delete(Banner banner);

    public void updete(Banner banner);

    public void insert(Banner banner, HttpSession session, MultipartFile file) throws IOException;

    public BannerDto selectByPage(Integer Page, Integer pageSize);

}
