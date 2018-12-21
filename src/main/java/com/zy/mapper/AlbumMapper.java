package com.zy.mapper;

import com.zy.entity.Album;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {
    public List<Album> queryAll(@Param("page") int Page, @Param("pageSize") int pageSize);
}
