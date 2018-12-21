package com.zy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album implements Serializable {
    @Id
    private Long id;
    private String title;
    private Integer count;
    private String coverImg;
    private Integer score;
    private String author;
    private String broadcast;
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pubDate;
    private List<Chapter> children;
}
