package com.vageables.shop.repository;

import com.vageables.shop.entity.Confirmorder;
import com.vageables.shop.entity.Goods;
import com.vageables.shop.entity.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 13:24
 * @description : --Confirmorder类描述--
 */

@Repository
public interface ConfirmorderRepository extends JpaRepository<Confirmorder, Integer> {
    List<Confirmorder> findAllByUserid(Integer userid);

    @Query("select g from Confirmorder g order by g.id desc")
    List<Confirmorder> getMaxID();
}
