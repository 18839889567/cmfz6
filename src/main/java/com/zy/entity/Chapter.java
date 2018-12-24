package com.zy.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Chapter implements Serializable {
    @Id
    @Excel(name = "音频ID", height = 20, width = 30, isImportField = "true_st")
    private String id;
    @Excel(name = "音频名称")
    private String title;
    @Excel(name = "音频大小")
    private Double size;
    @Excel(name = "音频ID")
    private String duration;
    @Excel(name = "音频地址")
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "上传日期", format = "YYYY年MM月dd日", width = 20)
    private Date uploadDate;
    @ExcelIgnore
    private Long aId;
}
