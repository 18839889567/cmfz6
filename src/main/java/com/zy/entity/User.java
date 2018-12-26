package com.zy.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @Excel(name = "ID")
    private Long id;
    @Excel(name = "电话")
    private String phone;
    @Excel(name = "密码")
    private String password;
    @Excel(name = "盐")

    private String salt;
    //签名
    @Excel(name = "签名", type = 2, imageType = 1)
    private String sign;
    @Excel(name = "头像")

    private String headPic;
    @Excel(name = "名字")

    private String name;
    @Excel(name = "法号")

    private String dharma;
    @Excel(name = "性别")

    private String sex;
    @Excel(name = "省份")
    private String province;
    @Excel(name = "城市")
    private String city;
    @Excel(name = "状态")
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册时间")
    private Date regDate;
}
