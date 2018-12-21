package com.zy.serviceImpl;


import com.zy.entity.Album;
import com.zy.entity.AlbumDto;
import com.zy.mapper.AlbumMapper;
import com.zy.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumMapper albumMapper;

    @Override
    public AlbumDto queryAll(Integer pageNum, Integer pageSize) {
        //PageHelper.startPage(pageNum,pageSize);
        AlbumDto albumDto = new AlbumDto();
        albumDto.setRows(albumMapper.queryAll(pageNum, pageSize));
        albumDto.setTotal(albumMapper.selectCount(new Album()));
        return albumDto;
    }

    @Override
    public void insert(Album album, HttpSession session, MultipartFile file) throws IOException {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/img/Album/");
        String filename = file.getOriginalFilename();

        File file1 = new File(realPath + "/" + filename);
//        //上传
        file.transferTo(file1);
        album.setCoverImg("/img/Album/" + filename);
        album.setCount(0);
        albumMapper.insert(album);
    }

    @Override
    public Album queryById(Album album) {
        return albumMapper.selectOne(album);
    }
}
