package com.vageables.shop.repository;

import com.vageables.shop.entity.Shoporder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 14:33
 * @description : --Shoporder类描述--
 */

@Repository
public interface ShoporderRepository extends JpaRepository<Shoporder, Integer> {
    List<Shoporder> findAllByOrderid(Integer orderid);
}
