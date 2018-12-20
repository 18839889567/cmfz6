package com.zy.serviceImpl;

import com.zy.entity.Banner;
import com.zy.entity.BannerDto;
import com.zy.mapper.BannerMapper;
import com.zy.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Override
    public void delete(Banner banner) {

        bannerMapper.delete(banner);
    }

    @Override
    public void updete(Banner banner) {
        banner.setPubDate(new Date());
        bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    public void insert(Banner banner, HttpSession session, MultipartFile file) throws IOException {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/img");
        String filename = file.getOriginalFilename();

        File file1 = new File(realPath + "/" + filename);
        //上传
        file.transferTo(file1);
        banner.setImgPath("/img/" + filename);
        banner.setPubDate(new Date());
        bannerMapper.insert(banner);
    }

    @Override
    public BannerDto selectByPage(Integer Page, Integer pageSize) {
        BannerDto dto = new BannerDto();
        dto.setRows(bannerMapper.selectByPage(Page, pageSize));
        dto.setTotal(bannerMapper.selectTotalCount());
        return dto;
    }
}
