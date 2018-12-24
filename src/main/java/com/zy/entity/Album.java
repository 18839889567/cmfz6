package com.zy.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelTarget(value = "album")
public class Album implements Serializable {
    @Id
    @ExcelIgnore
    private Long id;
    @Excel(name = "主题", needMerge = true)
    private String title;
    @Excel(name = "数量", needMerge = true)
    private Integer count;
    @Excel(name = "图片", type = 2, needMerge = true, imageType = 1)
    private String coverImg;
    @Excel(name = "评分", needMerge = true)
    private Integer score;
    @Excel(name = "作者", needMerge = true)
    private String author;
    @Excel(name = "播音者", needMerge = true)
    private String broadcast;
    @Excel(name = "简介", needMerge = true)
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期", format = "YYYY年MM月dd日", width = 20)
    private Date pubDate;
    @Transient
    @ExcelCollection(name = "学生", orderNum = "2")
    private List<Chapter> children;
}
