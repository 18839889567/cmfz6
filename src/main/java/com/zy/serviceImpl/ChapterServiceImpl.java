package com.zy.serviceImpl;

import com.zy.entity.Chapter;
import com.zy.mapper.ChapterMapper;
import com.zy.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    ChapterMapper chapterMapper;

    @Override
    public void insert(Chapter chapter, HttpSession session, MultipartFile file) throws IOException {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/img/chapter");
        System.out.println("realPath=" + realPath);
        String filename = file.getOriginalFilename();
        System.out.println("filename=" + filename);
        File file1 = new File(realPath + "/" + filename);
        file.transferTo(file1);
        chapter.setUploadDate(new Date());
        chapter.setUrl("" + filename);
        System.out.println("chapter=" + chapter);
        chapterMapper.insert(chapter);
    }

    @Override
    public void download(String url, HttpSession session, HttpServletResponse response) throws IOException {
        String realPath = session.getServletContext().getRealPath("/img/chapter");
        File file = new File(realPath + "\\" + url);
        byte[] bytes = FileCopyUtils.copyToByteArray(file);
        System.out.println(realPath + "\\" + url);
        response.setHeader("content-disposition", "attchment;filename=" + URLEncoder.encode(url, "utf-8"));
        ServletOutputStream sos = response.getOutputStream();
        sos.write(bytes);
    }
}
