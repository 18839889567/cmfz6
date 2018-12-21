package com.zy.service;


import com.zy.entity.Album;
import com.zy.entity.AlbumDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;


public interface AlbumService {
    public AlbumDto queryAll(Integer pageNum, Integer pageSize);

    public void insert(Album album, HttpSession session, MultipartFile file) throws IOException;

    public Album queryById(Album album);
}
