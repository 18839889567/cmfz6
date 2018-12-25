package com.zy.serviceImpl;

import com.zy.entity.Chapter;
import com.zy.mapper.ChapterMapper;
import com.zy.service.ChapterService;
import com.zy.util.RandomSaltUtil;
import org.apache.commons.io.FilenameUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

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
    public void insert(Chapter chapter, HttpSession session, MultipartFile audio/*, MultipartHttpServletRequest multipartHttpServletRequest*/) {

        String realPath = session.getServletContext().getRealPath("/");
        String dir = realPath + "img/chapter";
        File file = new File(dir);
        //如果路径不存在 则创建路径
        if (!file.exists()) {
            file.mkdir();
        }
        //重命名   让每一个文件都有唯一名字
        String filename = audio.getOriginalFilename();
        //获取后缀名   getExtension方法可以获取文件后缀 避免文件名为  你.好.mp3不好去除后缀
        String extension = FilenameUtils.getExtension(filename);
        String newName = UUID.randomUUID().toString();
        chapter.setId(newName);
        //用uuid   +后缀名 做上传的文件名字
        newName = newName + "." + extension;


        //文件上传到 指定位置
        try {
            audio.transferTo(new File(dir, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置其他属性的值  放入数据库中

        chapter.setUploadDate(new Date());
        chapter.setUrl(newName);
        int size = (int) (audio.getSize() / 1024.0 / 1024.0 * 100);
        chapter.setSize(size / 100.0);

        //获取文件时长
        MP3File f = null;
        try {
            f = (MP3File) AudioFileIO.read(file);
        } catch (CannotReadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TagException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            e.printStackTrace();
        } catch (InvalidAudioFrameException e) {
            e.printStackTrace();
        }
        MP3AudioHeader audioHeader = f.getMP3AudioHeader();
        Integer duration = audioHeader.getTrackLength();
        Integer hour = duration / 3600;   //小时
        Integer min = (duration - hour * 3600) / 60;   //分钟
        Integer seconds = (duration - hour * 3600 - min * 60);  //秒
        String Realduration = hour + ":" + min + ":" + seconds;
        chapter.setDuration(Realduration);

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
