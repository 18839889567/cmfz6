package com.zy.controller;


import com.zy.entity.Chapter;
import com.zy.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    ChapterService chapterService;

    @RequestMapping("insert")
    public void insert(Chapter chapter, HttpSession session, MultipartFile file) throws IOException {
        chapterService.insert(chapter, session, file);
    }

    @RequestMapping("download")
    public void download(String url, HttpSession session, HttpServletResponse response) throws IOException {
        chapterService.download(url, session, response);
    }
}
