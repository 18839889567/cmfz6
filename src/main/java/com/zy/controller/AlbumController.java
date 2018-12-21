package com.zy.controller;

import com.zy.entity.Album;
import com.zy.entity.AlbumDto;
import com.zy.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;


@RestController
@RequestMapping("album")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @RequestMapping("queryAll")
    public AlbumDto queryAll(Integer page, Integer rows) {
        return albumService.queryAll(page, rows);
    }

    @RequestMapping("queryOne")
    public Album queryOne(Album album) {
        return albumService.queryById(album);
    }

    @RequestMapping("insert")
    public void insert(Album album, HttpSession session, MultipartFile file) {
        try {
            albumService.insert(album, session, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
