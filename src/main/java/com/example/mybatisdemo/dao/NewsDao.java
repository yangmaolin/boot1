package com.example.mybatisdemo.dao;

import com.example.mybatisdemo.pojo.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 该接口负责表News的持久操作
 */
@Repository
public interface NewsDao extends JpaRepository<News,Integer> {

    @Query(value = "select n from News n where n.nid= :nid")
    News findNewsByNid(@Param("nid")int nid);

}
