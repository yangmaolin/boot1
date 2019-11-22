package com.example.mybatisdemo.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户实体类
 */
@Entity
@Table(name = "user")//JPA定义数据库表名，可自动生成
public class User implements Serializable {

    //serialVersionUID作用是为了在软件更改后正常地序列化和反序列化
    public static final long serialVersionUID = 1L;

    @Id//标记主键
    @GeneratedValue(strategy = GenerationType.AUTO)//设置自增
    public Integer id;

    @Column(length = 12)//设置长度
    public String username;

    @Column(length = 12)//设置长度
    public String password;
    public String phone;
    public Integer level;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
