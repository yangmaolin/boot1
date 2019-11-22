package com.example.mybatisdemo.dao;

import com.example.mybatisdemo.pojo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *Dao层接口继承了JpaRepository，其中封装了一些访问数据库的方法
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer>{
    /**
     * 根据账户和密码查找用户
     * @param name 账户
     * @param password 密码
     * @return 用户实体
     */
    @Query(value = "select u from User u where u.username= :name AND u.password= :password")
    User findOne(@Param("name") String name, @Param("password") String password);

    /**
     * 更新用户信息
     * @param user 用户实体
     */
    @Modifying//updata操作需加
    @Transactional//updata操作需加
//    @Query(value = "update User u set u.username=:#{#user.username},u.password=:#{#user.password},u.phone=:#{#user.phone} where u.id =:#{#user.id}")
//    void updataUser(User user); 此处报错，hql语句写法有误，具体可百度
    @Query(value = "update User u set u.username= :username,u.password= :password,u.phone= :phone where u.id = :id")
    void updataUser(@Param("id")Integer id,@Param("username")String username,@Param("password")String password,@Param("phone")String phone);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @Query(value = "select u from User u where u.id= :id")
    User findUserById(@Param("id")Integer id);

    /**
     * 查找所有普通用户
     * @return
     */
    @Query(value = "select u from User u where u.level = 1")
    List<User> findALlUser();

    /**
     * 查找所有管理员
     * @return
     */
    @Query(value = "select u from User u where u.level = 2")
    List<User> findAllManager();

    /**
     * 升级用户级别
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "update User u set u.level= 2 where u.id = :id")
    void upUserLevel(@Param("id")int id);

    /**
     * root用户降职管理员
     */
    @Modifying
    @Transactional
    @Query(value = "update User u set u.level= 1  where u.id = :id")
    void downManagerLevel(@Param("id")int id);

    @Query(value = "select u from User u where u.username= :username and u.password= :password")
    User findUserByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
}
