package com.example.mybatisdemo.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 新闻实体类
 * 属性id标注为外键，为user的id
 */
@Entity
@Table(name="news")
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nid;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="id")
    private Integer id;

    private Integer status;
    private String title;
    private String imgfile;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    private String word;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgfile() {
        return imgfile;
    }

    public void setImgfile(String imgfile) {
        this.imgfile = imgfile;
    }
}
