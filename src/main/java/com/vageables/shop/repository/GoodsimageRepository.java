package com.vageables.shop.repository;

import com.vageables.shop.entity.Goodsimage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 14:19
 * @description : --GoodsimageRepository类描述--
 */

@Repository
public interface GoodsimageRepository extends JpaRepository<Goodsimage, Integer> {

    List<Goodsimage> findAllByGoodsid(Integer good);

    @Transactional
    @Modifying
    @Query("delete from Goodsimage g where g.goodsid = ?1")
    void deleteAllByGood(Integer goodid);
}
