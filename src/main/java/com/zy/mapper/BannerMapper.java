package com.zy.mapper;

import com.zy.entity.Banner;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BannerMapper extends Mapper<Banner> {
    public List<Banner> selectByPage(@Param("page") int Page, @Param("pageSize") int pageSize);//分页查询

    public Integer selectTotalCount();

    public List<Banner> selectA();
}
