package com.zy.service;

import com.zy.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface ChapterService {
    public void insert(Chapter chapter, HttpSession session, MultipartFile file) throws IOException;

    public void download(String url, HttpSession session, HttpServletResponse response) throws IOException;
}
