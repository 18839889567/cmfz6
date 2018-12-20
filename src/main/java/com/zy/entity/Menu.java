package com.zy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {
    @Id
    private Integer id;
    private String title;
    /*图标*/

    private String iconcls;
    //跳转的路径

    private String url;
    // private Integer parentId;
    private List<Menu> list;
}
