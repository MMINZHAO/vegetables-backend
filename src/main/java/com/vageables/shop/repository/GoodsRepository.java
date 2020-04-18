package com.vageables.shop.repository;

import com.vageables.shop.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 13:34
 * @description : --GoodsRepository类描述--
 */

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    List<Goods> findAllByCateid(Integer cateid);
    List<Goods> findGoodsByGoodspriceBetween(BigDecimal b1, BigDecimal b2);
    List<Goods> findGoodsByGoodsnameContainingOrGoodsinfoContaining(String goodsname, String goodsinfo);
    List<Goods> findGoodsByCateidOrderByGoodspriceAsc(Integer cateid);

    @Query("select g from Goods g order by g.id desc")
    List<Goods> getMaxID();
}
