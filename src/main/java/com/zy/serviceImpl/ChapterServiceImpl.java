package com.zy.serviceImpl;

import com.zy.entity.Chapter;
import com.zy.mapper.ChapterMapper;
import com.zy.service.ChapterService;
import com.zy.util.RandomSaltUtil;
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
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    ChapterMapper chapterMapper;
    @Autowired
    RandomSaltUtil randomSaltUtil;

    @Override
    public void insert(Chapter chapter, HttpSession session, MultipartFile file/*, MultipartHttpServletRequest multipartHttpServletRequest*/) throws IOException {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/img/chapter");
        String filename = file.getOriginalFilename();
        //获取文件大小

//        //获取文件时长
//        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
//        while (iterator.hasNext()){
//           // MultipartFile file1 = multipartHttpServletRequest.getFile(iterator.next());
//            file.getOriginalFilename();
//        }

        chapter.setId(UUID.randomUUID().toString());
        File file1 = new File(realPath + "/" + filename);
        file.transferTo(file1);

        chapter.setUploadDate(new Date());
        chapter.setUrl("" + filename);
        int size = (int) (file.getSize() / 1024.0 / 1024.0 * 100);
        chapter.setSize(size / 100.0);
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
